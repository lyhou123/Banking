package org.pratice.banking.feature.accounttyperepository;
import org.pratice.banking.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,String> {
}
