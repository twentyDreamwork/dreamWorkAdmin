package dream.work.service.mapper;

import dream.work.mapper.EntityMapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dream.work.domain.Log;
import dream.work.service.dto.LogErrorDTO;

/**
 * @author jie
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogErrorMapper extends EntityMapper<LogErrorDTO, Log> {

}