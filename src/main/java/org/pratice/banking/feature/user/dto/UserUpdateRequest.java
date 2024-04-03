package org.pratice.banking.feature.user.dto;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Set;
@Builder
public record UserUpdateRequest(
        String username,
        String fullName,
        String gender,
        String pin,
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
