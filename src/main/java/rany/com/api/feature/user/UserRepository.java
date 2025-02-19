package rany.com.api.feature.user;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.User;

import java.util.Set;

public interface UserRepository extends JpaRepository<User,Long> {


    Set<User> findByUserName(String userName);
}
