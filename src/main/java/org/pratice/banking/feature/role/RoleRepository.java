package org.pratice.banking.feature.role;
import org.pratice.banking.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface RoleRepository extends JpaRepository<Role, String> {
  Optional<Role> findByName(String name);

}
