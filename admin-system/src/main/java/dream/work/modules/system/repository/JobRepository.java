package dream.work.modules.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dream.work.modules.system.domain.Job;

/**
* @author jie
* @date 2019-03-29
*/
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor {
}