package dream.work.modules.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dream.work.modules.system.domain.Dict;

/**
* @author jie
* @date 2019-04-10
*/
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor {
}