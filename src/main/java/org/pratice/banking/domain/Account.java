package org.pratice.banking.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts_tbl")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String id;
    private String name;
    private String accountNumber;
    private String accountType;
    private BigDecimal accountBalance;
    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType1;
    @OneToMany(mappedBy = "account")
    Set<UserAccount> userAccounts;

}
