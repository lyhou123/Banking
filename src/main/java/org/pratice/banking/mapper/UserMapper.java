package org.pratice.banking.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pratice.banking.domain.Role;
import org.pratice.banking.domain.User;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target="roles",expression = "java(mapRoles(user.getRoles()))")
    UserRespone mapToUserRespone(User user);

    //define method to set role set of string
    // this method that call depression method

    default Set<String> mapRoles(Set<Role> roleSet){
     return roleSet.stream().map(Role::getName).collect(Collectors.toSet());
    }

    @Mapping(target="roles",ignore = true)
    User mapToUser(UserRequest userRequest);


}
