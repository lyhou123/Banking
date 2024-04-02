package org.pratice.banking.feature.user;

import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;

import java.util.List;

public interface UserService {
    UserRespone createUser(UserRequest userRequest);
    List<UserRespone> getAllUsers();
    UserRespone getUserById(String id);
    UserRespone deleteUser(String id);
    UserRespone updateUser(String id, UserRequest userRequest);
    UserRespone enableUser(String id);
    UserRespone disableUser(String id);
}
