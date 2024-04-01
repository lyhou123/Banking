package org.pratice.banking.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "full name is required")
    private String fullName;
    @NotEmpty(message= "gender is required")
    private String gender ;
    @Size(min = 6, max = 6, message = "pin must be 6 digits")
    private String pin;
    @Email(message = "your must provide a valid email address")
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
