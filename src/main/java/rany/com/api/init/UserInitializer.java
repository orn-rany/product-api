package rany.com.api.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import rany.com.api.domain.Role;
import rany.com.api.domain.User;
import rany.com.api.feature.role.RoleRepository;
import rany.com.api.feature.user.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;

    public void initUsers() {
        List<User> users = List.of(
            createUser("admin", "123456", "admin@example.com", "0123456789", "Male", "Admin Address", "ADMIN"),
            createUser("rany", "123456", "rany@example.com", "0987654321", "Male", "Rany Address", "ADMIN"),
            createUser("customer", "123456", "customer@example.com", "011223344", "Female", "Customer Address", "CUSTOMER"),
            createUser("employee", "123456", "employee@example.com", "066778899", "Male", "Employee Address", "EMPLOYEE"),
            createUser("manager", "123456", "manager@example.com", "099887766", "Female", "Manager Address", "EMPLOYEE")
        );

        for (User user : users) {

            if (userRepository.findByUserName(user.getUserName()).isEmpty()) {
               userRepository.save(user);
            }
        }
    }

    private User createUser(String username, String password, String email, String phone, String gender, String address, String roleName) {
        Optional<Role> role = roleRepository.findByRoleName(roleName);
        if (role.isEmpty()) {
            Role newRole = new Role();
            newRole.setRoleName(roleName);
            roleRepository.save(newRole);
            role = Optional.of(newRole);
        }

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        user.setGender(gender);
        user.setAddress(address);
        user.setDob(LocalDate.of(2000, 1, 1));
        user.setRole(role.get());

        return user;
    }
}
