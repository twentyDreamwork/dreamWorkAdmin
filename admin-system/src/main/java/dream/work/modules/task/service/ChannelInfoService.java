package dream.work.modules.task.service;

import dream.work.modules.task.domain.ChannelInfo;
import dream.work.modules.task.service.dto.ChannelInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author Yang
* @date 2019-06-22
*/
@CacheConfig(cacheNames = "channelInfo")
public interface ChannelInfoService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    ChannelInfoDTO findById(String id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    ChannelInfoDTO create(ChannelInfo resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(ChannelInfo resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}