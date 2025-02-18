package rany.com.api.feature.user;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import rany.com.api.feature.user.dto.UserCreateRequest;
import rany.com.api.feature.user.dto.UserResponse;
import rany.com.api.feature.user.dto.UserUpdateRequest;


@Service
public class UserServiceImpl implements UserService{
    @Override
    public void createUser(UserCreateRequest userCreateRequest) {

    }

    @Override
    public UserResponse getUserById(Long id) {
        return null;
    }

    @Override
    public Page<UserResponse> getAllUsers(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
