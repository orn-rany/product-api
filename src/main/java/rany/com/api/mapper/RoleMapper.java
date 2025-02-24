package rany.com.api.mapper;

import org.mapstruct.*;
import rany.com.api.domain.Role;
import rany.com.api.domain.User;
import rany.com.api.feature.role.dto.RoleCreateRequest;
import rany.com.api.feature.role.dto.RoleResponse;
import rany.com.api.feature.role.dto.RoleUpdateRequest;
import rany.com.api.feature.user.dto.UserCreateRequest;
import rany.com.api.feature.user.dto.UserResponse;
import rany.com.api.feature.user.dto.UserUpdateRequest;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromUserCreateRequest(RoleCreateRequest roleCreateRequest);

    @Mapping(source = "id",target = "id")
    RoleResponse toRoleResponse(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleFromRequest(@MappingTarget Role role, RoleUpdateRequest roleUpdateRequest);

}
