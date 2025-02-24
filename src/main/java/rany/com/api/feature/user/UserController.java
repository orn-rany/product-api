package rany.com.api.feature.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rany.com.api.feature.user.dto.UserCreateRequest;
import rany.com.api.feature.user.dto.UserResponse;
import rany.com.api.feature.user.dto.UserUpdateRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {

        userService.createUser(userCreateRequest);
    }

    @GetMapping
    public Page<UserResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "25") int pageSize) {

        return userService.getAllUsers(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PatchMapping("/{id}")
    public UserResponse updateUserById(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest) {

        return userService.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id) {

        userService.deleteUser(id);
    }


}
