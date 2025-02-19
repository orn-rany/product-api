package rany.com.api.feature.role;

import org.springframework.data.domain.Page;
import rany.com.api.feature.role.dto.RoleCreateRequest;
import rany.com.api.feature.role.dto.RoleResponse;
import rany.com.api.feature.role.dto.RoleUpdateRequest;

public interface RoleService {

    void createRole(RoleCreateRequest roleCreateRequest);

    RoleResponse getRoleById(Long id);

    Page<RoleResponse> getAllRoles(int pageNumber, int pageSize);

    RoleResponse updateRoleById(Long id, RoleUpdateRequest roleUpdateRequest);

    void deleteRoleById(Long id);
}
