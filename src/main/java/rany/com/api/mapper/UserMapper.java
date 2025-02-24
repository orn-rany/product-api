package rany.com.api.mapper;

import org.mapstruct.*;
import rany.com.api.domain.Product;
import rany.com.api.domain.User;
import rany.com.api.feature.product.dto.ProductUpdateRequest;
import rany.com.api.feature.user.dto.UserCreateRequest;
import rany.com.api.feature.user.dto.UserResponse;
import rany.com.api.feature.user.dto.UserUpdateRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserCreateRequest(UserCreateRequest userCreateRequest);

    @Mapping(source = "userName",target = "userName")
    UserResponse toUserResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromRequest(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

}
