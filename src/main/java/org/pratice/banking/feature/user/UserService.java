package org.pratice.banking.feature.user;

import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;

public interface UserService {
    UserRespone createUser(UserRequest userRequest);
}
