package rany.com.api.feature.role;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rany.com.api.feature.role.dto.RoleCreateRequest;
import rany.com.api.feature.role.dto.RoleResponse;
import rany.com.api.feature.role.dto.RoleUpdateRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@Valid @RequestBody RoleCreateRequest roleCreateRequest){

        roleService.createRole(roleCreateRequest);
    }

    @GetMapping
    public Page<RoleResponse> getAllRoles(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "25") int pageSize) {

      return   roleService.getAllRoles(pageNumber,pageSize);

    }

    @GetMapping("/{id}")
    public RoleResponse getRoleById(@PathVariable Long id){

        return  roleService.getRoleById(id);
    }

    @PatchMapping("/{id}")
    public RoleResponse updateRoleById(@PathVariable Long id, @Valid @RequestBody RoleUpdateRequest roleUpdateRequest){

        return  roleService.updateRoleById(id,roleUpdateRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteRoleById(@PathVariable Long id){

        roleService.deleteRoleById(id);
    }
}
