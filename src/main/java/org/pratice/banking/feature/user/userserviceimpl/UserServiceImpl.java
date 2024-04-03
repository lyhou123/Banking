package org.pratice.banking.feature.user.userserviceimpl;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.domain.Role;
import org.pratice.banking.domain.User;
import org.pratice.banking.feature.role.RoleRepository;
import org.pratice.banking.feature.user.UserService;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
import org.pratice.banking.feature.user.dto.UserUpdateRequest;
import org.pratice.banking.feature.user.userepository.UserRepository;
import org.pratice.banking.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    @Override
    public UserRespone createUser(UserRequest userRequest) {
          if(userRepository.existsByUsername(userRequest.username()))
          {
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Username already exist");
       }if(userRepository.existsByEmail(userRequest.email()))
          {
              throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already Token");
          }
        Set<Role> roles=new HashSet<>();
       for(var role:userRequest.roles())
       {
           var roleObj=roleRepository.findByName(role).orElseThrow(()->
                   new ResponseStatusException(HttpStatus.BAD_REQUEST,"Role not found"));
           roles.add(roleObj);
       }
       User newUser=userMapper.mapToUser(userRequest);
       newUser.setIsBlocked(false);
       newUser.setIsDeleted(false);
       newUser.setRoles(roles);
       var savedUser=userRepository.save(newUser);
      return userMapper.mapToUserRespone(savedUser);
    }

    @Override
    public List<UserRespone> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::mapToUserRespone)
                .toList();
    }
    @Override
    public UserRespone getUserById(String id) {
        var newProduct=userRepository.findById(id).orElseThrow();// null if not found
        return userMapper.mapToUserRespone(newProduct);
    }

    @Override
    public UserRespone deleteUser(String id) {
        var user=userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return userMapper.mapToUserRespone(user);
    }

    @Override
    public UserRespone updateUser(String id, UserUpdateRequest userUpdateRequest) {
         var newProduct=userRepository.findById(id).orElseThrow();
         userMapper.updateUserFromRequest(newProduct,userUpdateRequest);
         newProduct.setId(id);
       return userMapper.mapToUserRespone(userRepository.save(newProduct));
    }

    @Override
    public UserRespone enableUser(String id) {
        int effect= userRepository.updateBlockedStatusById(id,false);
        if(effect<0)
        {
            return userMapper.mapToUserRespone(userRepository.findById(id).orElseThrow(null));

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User with id="+id+" doesn't exits");
        }
    }
    @Override
    public UserRespone disableUser(String id) {
        int effect= userRepository.updateBlockedStatusById(id,true);
        if(effect>0)
        {
            return userMapper.mapToUserRespone(userRepository.findById(id).orElseThrow(null));

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User with id="+id+" doesn't exits");
        }
    }
}
