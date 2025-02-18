package rany.com.api.feature.user;

import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
