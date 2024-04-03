package org.pratice.banking.feature.user;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.feature.user.dto.UserRequest;
import org.pratice.banking.feature.user.dto.UserRespone;
import org.pratice.banking.feature.user.dto.UserUpdateRequest;
import org.pratice.banking.utils.BaseRespone;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    @PostMapping("/register")
    @Operation(summary = "Get all users",requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody
            (
                    content =@Content(
                            schema = @Schema(implementation = UserRequest.class),
                            examples = @ExampleObject(value = """
                                    {
                                                                   "username": "Lyhou",
                                                                   "fullName": "string",
                                                                   "gender": "male",
                                                                   "pin": "898989",
                                                                   "email": "Lyhou@gmail.com",
                                                                   "password": "string",
                                                                   "profileImage": "string",
                                                                   "phoneNumber": "string",
                                                                   "cityOrProvince": "string",
                                                                   "khanOrDistrict": "string",
                                                                   "sangkatOrCommune": "string",
                                                                   "employeeType": "string",
                                                                   "companyName": "string",
                                                                   "mainSourceOfIncome": "string",
                                                                   "monthlyIncomeRange": 0,
                                                                   "studentCardId": "string",
                                                                   "roles": [
                                                                     "ADMIN","STUFF"
                                                                   ]
                                        
                                    }
                                    """)
                    )))
    public BaseRespone<UserRespone> registerUser(@Valid @RequestBody UserRequest userRequest) {
        return BaseRespone.<UserRespone>creatSuccess()
                .setPaylot(userService.createUser(userRequest));
    }
    @GetMapping("/getAll")
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
    public BaseRespone<UserRespone> updateUser(@PathVariable String id,@RequestBody UserUpdateRequest userRequest)
    {
        return BaseRespone.<UserRespone>updateSuccess()
                .setPaylot(userService.updateUser(id,userRequest));
    }
    @PutMapping("/{id}/enable")
    public BaseRespone<UserRespone> enableUser(@PathVariable String id)
    {
        return BaseRespone.<UserRespone>creatSuccess()
                .setPaylot(userService.enableUser(id));
    }
    @PutMapping("/{id}/disable")
    public BaseRespone<UserRespone> disableUser(@PathVariable String id)
    {
        return BaseRespone.<UserRespone>creatSuccess()
                .setPaylot(userService.disableUser(id));
    }
}
