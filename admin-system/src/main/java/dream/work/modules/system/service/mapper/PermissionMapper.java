package dream.work.modules.system.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dream.work.mapper.EntityMapper;
import dream.work.modules.system.domain.Permission;
import dream.work.modules.system.service.dto.PermissionDTO;

/**
 * @author jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
