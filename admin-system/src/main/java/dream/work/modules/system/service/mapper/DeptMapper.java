package dream.work.modules.system.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dream.work.mapper.EntityMapper;
import dream.work.modules.system.domain.Dept;
import dream.work.modules.system.service.dto.DeptDTO;

/**
* @author jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends EntityMapper<DeptDTO, Dept> {

}