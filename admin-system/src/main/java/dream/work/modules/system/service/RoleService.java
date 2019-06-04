package dream.work.modules.system.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import dream.work.modules.system.domain.Menu;
import dream.work.modules.system.domain.Role;
import dream.work.modules.system.service.dto.RoleDTO;
import dream.work.modules.system.service.dto.RoleSmallDTO;

import java.util.List;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-03
 */
@CacheConfig(cacheNames = "role")
public interface RoleService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    RoleDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    RoleDTO create(Role resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Role resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * key的名称如有修改，请同步修改 UserServiceImpl 中的 update 方法
     * findByUsers_Id
     * @param id
     * @return
     */
    @Cacheable(key = "'findByUsers_Id:' + #p0")
    List<RoleSmallDTO> findByUsers_Id(Long id);

    @Cacheable(keyGenerator = "keyGenerator")
    Integer findByRoles(Set<Role> roles);

    /**
     * updatePermission
     * @param resources
     * @param roleDTO
     */
    @CacheEvict(allEntries = true)
    void updatePermission(Role resources, RoleDTO roleDTO);

    /**
     * updateMenu
     * @param resources
     * @param roleDTO
     */
    @CacheEvict(allEntries = true)
    void updateMenu(Role resources, RoleDTO roleDTO);

    @CacheEvict(allEntries = true)
    void untiedMenu(Menu menu);
}
