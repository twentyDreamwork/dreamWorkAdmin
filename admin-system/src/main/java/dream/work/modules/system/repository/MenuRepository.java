package dream.work.modules.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dream.work.modules.system.domain.Menu;
import dream.work.modules.system.domain.Role;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-17
 */
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    Menu findByName(String name);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<Menu> findByPid(long pid);

    LinkedHashSet<Menu> findByRoles_IdOrderBySortAsc(Long id);
}
