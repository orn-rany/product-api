package rany.com.api.feature.user;

import org.springframework.data.domain.Page;
import rany.com.api.feature.user.dto.UserCreateRequest;
import rany.com.api.feature.user.dto.UserResponse;
import rany.com.api.feature.user.dto.UserUpdateRequest;

public interface UserService {

    void createUser(UserCreateRequest userCreateRequest);

    UserResponse getUserById(Long id);

    Page<UserResponse> getAllUsers(int pageNumber, int pageSize);

    UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest);

    void deleteUser(Long id);
}
