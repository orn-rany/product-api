package rany.com.api.feature.role;

import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
