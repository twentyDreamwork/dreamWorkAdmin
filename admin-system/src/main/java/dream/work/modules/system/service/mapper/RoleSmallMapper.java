package dream.work.modules.system.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dream.work.mapper.EntityMapper;
import dream.work.modules.system.domain.Role;
import dream.work.modules.system.service.dto.RoleDTO;
import dream.work.modules.system.service.dto.RoleSmallDTO;

/**
 * @author jie
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends EntityMapper<RoleSmallDTO, Role> {

}
