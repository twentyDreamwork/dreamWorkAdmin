package dream.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dream.work.domain.AlipayConfig;

/**
 * @author jie
 * @date 2018-12-31
 */
public interface AlipayRepository extends JpaRepository<AlipayConfig,Long> {
}
