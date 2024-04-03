package org.pratice.banking.mapper;
import org.mapstruct.*;
import org.pratice.banking.domain.Role;
import org.pratice.banking.domain.User;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
import org.pratice.banking.feature.user.dto.UserUpdateRequest;

import java.lang.annotation.Target;
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
// @Mapping(target = "username",
//         source = "userUpdateRequest.username",
//         nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
//         defaultExpression = "java(user.getUsername())"
// )
 @Mapping(target="roles",ignore = true)
 @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
 void updateUserFromRequest(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

}
