package dream.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dream.work.domain.QiniuConfig;

/**
 * @author jie
 * @date 2018-12-31
 */
public interface QiNiuConfigRepository extends JpaRepository<QiniuConfig,Long> {
}
