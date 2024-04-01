package org.pratice.banking.feature.user;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
import org.pratice.banking.utils.BaseRespone;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    @PostMapping("/register")
    public BaseRespone<UserRespone> registerUser(@RequestBody UserRequest userRequest) {
        return BaseRespone.<UserRespone>creatSuccess()
                .setPaylot(userService.createUser(userRequest));
    }
}
