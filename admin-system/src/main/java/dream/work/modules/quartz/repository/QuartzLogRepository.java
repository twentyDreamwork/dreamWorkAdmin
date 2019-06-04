package dream.work.modules.quartz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dream.work.modules.quartz.domain.QuartzLog;

/**
 * @author jie
 * @date 2019-01-07
 */
public interface QuartzLogRepository extends JpaRepository<QuartzLog,Long>, JpaSpecificationExecutor {

}
