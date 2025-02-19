package rany.com.api.init;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import rany.com.api.domain.Role;
import rany.com.api.feature.role.RoleRepository;

import java.util.List;

@Component
public class RoleInitializer {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void initRoles() {

        List<String> roles = List.of("ADMIN", "EMPLOYEE", "CUSTOMER");

        for (String roleName : roles) {
            if (roleRepository.findByRoleName(roleName).isEmpty()) {
                Role role = new Role();
                role.setRoleName(roleName);
                roleRepository.save(role);
            }
        }
    }
}
