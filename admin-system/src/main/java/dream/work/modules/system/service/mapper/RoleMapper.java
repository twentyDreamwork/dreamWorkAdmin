package dream.work.modules.system.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dream.work.mapper.EntityMapper;
import dream.work.modules.system.domain.Role;
import dream.work.modules.system.service.dto.RoleDTO;

/**
 * @author jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {PermissionMapper.class, MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

}
