package dream.work.modules.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import dream.work.modules.system.domain.Role;
import dream.work.modules.system.repository.RoleRepository;
import dream.work.modules.system.service.dto.UserDTO;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "role")
public class JwtPermissionService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * key的名称如有修改，请同步修改 UserServiceImpl 中的 update 方法
     * @param user
     * @return
     */
    @Cacheable(key = "'loadPermissionByUser:' + #p0.username")
    public Collection<GrantedAuthority> mapToGrantedAuthorities(UserDTO user) {

        System.out.println("--------------------loadPermissionByUser:" + user.getUsername() + "---------------------");

        Set<Role> roles = roleRepository.findByUsers_Id(user.getId());

        return roles.stream().flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
    }
}
