package org.pratice.banking.feature.user.userserviceimpl;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.domain.Role;
import org.pratice.banking.domain.User;
import org.pratice.banking.feature.role.RoleRepository;
import org.pratice.banking.feature.user.UserService;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
import org.pratice.banking.feature.user.userepository.UserRepository;
import org.pratice.banking.mapper.UserMapper;
import org.springframework.stereotype.Service;

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
        Set<Role> roles=new HashSet<>();
       for(var role:userRequest.roles())
       {
           var roleObj=roleRepository.findByName(role).orElseThrow(()->
                   new NoSuchElementException("Role not found"));
           roles.add(roleObj);
       }
       User newUser=userMapper.mapToUser(userRequest);
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
    public UserRespone updateUser(String id, UserRequest userRequest) {
         var newProduct=userRepository.findById(id).orElseThrow();
         newProduct=userMapper.mapToUser(userRequest);
         newProduct.setId(id);
       return userMapper.mapToUserRespone(userRepository.save(newProduct));
    }
}
