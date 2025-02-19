package rany.com.api.feature.role;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rany.com.api.domain.Role;
import rany.com.api.domain.User;
import rany.com.api.feature.role.dto.RoleCreateRequest;
import rany.com.api.feature.role.dto.RoleResponse;
import rany.com.api.feature.role.dto.RoleUpdateRequest;
import rany.com.api.mapper.RoleMapper;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements  RoleService{

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Override
    public void createRole(RoleCreateRequest roleCreateRequest) {

        Role role = roleMapper.fromUserCreateRequest(roleCreateRequest);

        roleRepository.save(role);
    }

    @Override
    public RoleResponse getRoleById(Long id) {

        Role role = roleRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("role = %s has not been found",id)));

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public Page<RoleResponse> getAllRoles(int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC,"createdDate");

        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,sort);

        Page<Role> rolePage =roleRepository.findAll(pageRequest);

        return rolePage.map(roleMapper::toRoleResponse);
    }

    @Override
    public RoleResponse updateRoleById(Long id, RoleUpdateRequest roleUpdateRequest) {

        Role role = roleRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("role = %s has not been found",id)));

        roleMapper.updateRoleFromRequest(role,roleUpdateRequest);

        roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public void deleteRoleById(Long id) {

        Role role = roleRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("role = %s has not been found",id)));

        roleRepository.delete(role);
    }
}
