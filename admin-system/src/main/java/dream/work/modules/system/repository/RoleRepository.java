package dream.work.modules.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dream.work.modules.system.domain.Role;

import java.util.Set;

/**
 * @author jie
 * @date 2018-12-03
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    Role findByName(String name);

    Set<Role> findByUsers_Id(Long id);

    Set<Role> findByMenus_Id(Long id);
}
