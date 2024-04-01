package org.pratice.banking.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pratice.banking.domain.User;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target="roles",ignore = true)
    UserRespone mapToUserRespone(User user);
    @Mapping(target="roles",ignore = true)
    User mapToUser(UserRequest userRequest);

}
