package org.pratice.banking.feature.user;

import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
import org.pratice.banking.feature.user.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {
    UserRespone createUser(UserRequest userRequest);
    List<UserRespone> getAllUsers();
    UserRespone getUserById(String id);
    UserRespone deleteUser(String id);
    UserRespone updateUser(String id, UserUpdateRequest userUpdateRequest);
    UserRespone enableUser(String id);
    UserRespone disableUser(String id);
}
