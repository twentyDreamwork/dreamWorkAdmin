package dream.work.modules.task.rest;

import dream.work.aop.log.Log;
import dream.work.modules.task.domain.ChannelInfo;
import dream.work.modules.task.service.ChannelInfoService;
import dream.work.modules.task.service.dto.ChannelInfoDTO;
import dream.work.modules.task.service.query.ChannelInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author Yang
* @date 2019-06-22
*/
@RestController
@RequestMapping("api")
public class ChannelInfoController {

    @Autowired
    private ChannelInfoService channelInfoService;

    @Autowired
    private ChannelInfoQueryService channelInfoQueryService;

    @Log("查询ChannelInfo")
    @GetMapping(value = "/channelInfo")
    @PreAuthorize("hasAnyRole('ADMIN','CHANNELINFO_ALL','CHANNELINFO_SELECT')")
    public ResponseEntity getChannelInfos(ChannelInfoDTO resources, Pageable pageable){
        return new ResponseEntity(channelInfoQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增ChannelInfo")
    @PostMapping(value = "/channelInfo")
    @PreAuthorize("hasAnyRole('ADMIN','CHANNELINFO_ALL','CHANNELINFO_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ChannelInfo resources){
        return new ResponseEntity(channelInfoService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改ChannelInfo")
    @PutMapping(value = "/channelInfo")
    @PreAuthorize("hasAnyRole('ADMIN','CHANNELINFO_ALL','CHANNELINFO_EDIT')")
    public ResponseEntity update(@Validated @RequestBody ChannelInfo resources){
        channelInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ChannelInfo")
    @DeleteMapping(value = "/channelInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','CHANNELINFO_ALL','CHANNELINFO_DELETE')")
    public ResponseEntity delete(@PathVariable String id){
        channelInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}