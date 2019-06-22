package dream.work.modules.task.service;

import dream.work.modules.task.domain.UserInfo;
import dream.work.modules.task.service.dto.UserInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author Yang
* @date 2019-06-22
*/
@CacheConfig(cacheNames = "userInfo")
public interface UserInfoService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    UserInfoDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    UserInfoDTO create(UserInfo resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(UserInfo resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}