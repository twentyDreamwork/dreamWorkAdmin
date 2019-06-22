package dream.work.modules.task.rest;

import dream.work.aop.log.Log;
import dream.work.modules.task.domain.UserInfo;
import dream.work.modules.task.service.UserInfoService;
import dream.work.modules.task.service.dto.UserInfoDTO;
import dream.work.modules.task.service.query.UserInfoQueryService;
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
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoQueryService userInfoQueryService;

    @Log("查询UserInfo")
    @GetMapping(value = "/userInfo")
    @PreAuthorize("hasAnyRole('ADMIN','USERINFO_ALL','USERINFO_SELECT')")
    public ResponseEntity getUserInfos(UserInfoDTO resources, Pageable pageable){
        return new ResponseEntity(userInfoQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增UserInfo")
    @PostMapping(value = "/userInfo")
    @PreAuthorize("hasAnyRole('ADMIN','USERINFO_ALL','USERINFO_CREATE')")
    public ResponseEntity create(@Validated @RequestBody UserInfo resources){
        return new ResponseEntity(userInfoService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改UserInfo")
    @PutMapping(value = "/userInfo")
    @PreAuthorize("hasAnyRole('ADMIN','USERINFO_ALL','USERINFO_EDIT')")
    public ResponseEntity update(@Validated @RequestBody UserInfo resources){
        userInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除UserInfo")
    @DeleteMapping(value = "/userInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USERINFO_ALL','USERINFO_DELETE')")
    public ResponseEntity delete(@PathVariable String id){
        userInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}