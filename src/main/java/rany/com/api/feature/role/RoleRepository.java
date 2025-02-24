package rany.com.api.feature.role;

import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(String roleName);
}
