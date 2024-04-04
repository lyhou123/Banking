package org.pratice.banking.feature.accountrepository;

import com.sun.jdi.InterfaceType;
import org.pratice.banking.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account ,String> {
}
