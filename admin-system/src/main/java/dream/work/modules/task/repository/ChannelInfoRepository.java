package dream.work.modules.task.repository;

import dream.work.modules.task.domain.ChannelInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Yang
* @date 2019-06-22
*/
public interface ChannelInfoRepository extends JpaRepository<ChannelInfo, String>, JpaSpecificationExecutor {
}