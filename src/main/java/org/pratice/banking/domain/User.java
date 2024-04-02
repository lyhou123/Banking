package org.pratice.banking.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name="user_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private String id;
    private String username;

    private String fullName;

    private String gender ;

    private String pin;

    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles;
    private String profileImage;
    private String phoneNumber;
    private String cityOrProvince;
    private String khanOrDistrict;
    private String sangkatOrCommune;
    private String employeeType;
    private String companyName;
    private String mainSourceOfIncome;
    private BigDecimal monthlyIncomeRange;
    private String oneSignalId; // for notification
    private String studentIdCard;
    private Boolean isDeleted;  // for statistic usage!
    private Boolean isBlocked; // disable
    private LocalDateTime createdAt;

}
