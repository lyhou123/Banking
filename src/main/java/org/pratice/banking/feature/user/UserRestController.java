package org.pratice.banking.feature.user;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
import org.pratice.banking.utils.BaseRespone;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAll")
    @Operation(summary = "Get all users")
    public BaseRespone<List<UserRespone>> getAllUser()
    {
        return BaseRespone.<List<UserRespone>>OK()
                .setPaylot(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public BaseRespone<UserRespone> getUserById(@PathVariable String id)
    {
        return BaseRespone.<UserRespone>Found()
                .setPaylot(userService.getUserById(id));
    }
    @DeleteMapping("/{id}")
    public BaseRespone<UserRespone> deleteUser(@PathVariable String id)
    {
        return BaseRespone.<UserRespone>Delete()
                .setPaylot(userService.deleteUser(id));
    }
    @PutMapping("/{id}")
    public BaseRespone<UserRespone> updateUser(@PathVariable String id,@RequestBody UserRequest userRequest)
    {
        return BaseRespone.<UserRespone>creatSuccess()
                .setPaylot(userService.updateUser(id,userRequest));
    }
}
