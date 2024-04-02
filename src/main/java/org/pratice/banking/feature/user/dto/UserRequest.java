package org.pratice.banking.feature.user.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Set;
@Builder
public record UserRequest(
                        @NotEmpty(message = "full name is required")
                         String username,
                          String fullName,
                        @NotEmpty(message= "gender is required")
                          String gender,
                        @Size(min = 6, max = 6, message = "pin must be 6 digits")
                        @Pattern(regexp = "^[0-9]*$", message = "pin must be numeric")
                          String pin,
                        @Email(message = "your must provide a valid email address")
                          String email,
                          String password,
                          String profileImage,
                          String phoneNumber,
                          String cityOrProvince,
                          String khanOrDistrict,
                          String sangkatOrCommune,
                          String employeeType,
                          String companyName,
                          String mainSourceOfIncome,
                          BigDecimal monthlyIncomeRange,
                          String studentIdCard,
                          Set<String> roles

                          ) {
}
