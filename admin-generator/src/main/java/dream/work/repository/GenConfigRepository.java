package dream.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dream.work.domain.GenConfig;

/**
 * @author jie
 * @date 2019-01-14
 */
public interface GenConfigRepository extends JpaRepository<GenConfig,Long> {
}
