package dream.work.modules.task.service.mapper;

import dream.work.mapper.EntityMapper;
import dream.work.modules.task.domain.ChannelInfo;
import dream.work.modules.task.service.dto.ChannelInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Yang
* @date 2019-06-22
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChannelInfoMapper extends EntityMapper<ChannelInfoDTO, ChannelInfo> {

}