package org.pratice.banking.init;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.pratice.banking.domain.Role;
import org.pratice.banking.feature.role.RoleRepository;
import org.springframework.stereotype.Component;
import java.util.List;
//populating the database with some initial data
@Component
@RequiredArgsConstructor
public class DataInitailizer {
   private final RoleRepository roleRepository;
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
}
