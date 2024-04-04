package org.pratice.banking.init;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.domain.AccountType;
import org.pratice.banking.domain.Role;
import org.pratice.banking.feature.accounttyperepository.AccountTypeRepository;
import org.pratice.banking.feature.role.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//populating the database with some initial data
@Component
@RequiredArgsConstructor
public class DataInitailizer {
   private final RoleRepository roleRepository;
   private final AccountTypeRepository accountTypeRepository;
   @PostConstruct
    public void RoleInit() {
        List<String> roles=List.of("ADMIN","STUFF","USER");

        if(roleRepository.findAll().isEmpty())
        {
          for(var role:roles)
          {
             var roleObj=new Role();
             roleObj.setName(role);
             roleRepository.save(roleObj);
          }
        }
    }
    @PostConstruct
    public void AccountTypeInit() {
        List<AccountType> accountTypes=new ArrayList<>(){{
            add(new AccountType().setName("SAVING").setDescription("Saving Account"));
            add(new AccountType().setName("Payroll").setDescription("Payroll Account"));
            add(new AccountType().setName("Card").setDescription("Current Account"));
        }};
        if(accountTypeRepository.findAll().isEmpty())
        {
            accountTypeRepository.saveAll(accountTypes);
        }
    }
}
