package dream.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dream.work.domain.EmailConfig;

/**
 * @author jie
 * @date 2018-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
