package dream.work.modules.system.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dream.work.mapper.EntityMapper;
import dream.work.modules.system.domain.Dict;
import dream.work.modules.system.service.dto.DictDTO;

/**
* @author jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends EntityMapper<DictDTO, Dict> {

}