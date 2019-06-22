package dream.work.modules.task.service.query;

import dream.work.utils.PageUtil;
import dream.work.modules.task.domain.ChannelInfo;
import dream.work.modules.task.service.dto.ChannelInfoDTO;
import dream.work.modules.task.repository.ChannelInfoRepository;
import dream.work.modules.task.service.mapper.ChannelInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "channelInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ChannelInfoQueryService {

    @Autowired
    private ChannelInfoRepository channelInfoRepository;

    @Autowired
    private ChannelInfoMapper channelInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ChannelInfoDTO channelInfo, Pageable pageable){
        Page<ChannelInfo> page = channelInfoRepository.findAll(new Spec(channelInfo),pageable);
        return PageUtil.toPage(page.map(channelInfoMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ChannelInfoDTO channelInfo){
        return channelInfoMapper.toDto(channelInfoRepository.findAll(new Spec(channelInfo)));
    }

    class Spec implements Specification<ChannelInfo> {

        private ChannelInfoDTO channelInfo;

        public Spec(ChannelInfoDTO channelInfo){
            this.channelInfo = channelInfo;
        }

        @Override
        public Predicate toPredicate(Root<ChannelInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(channelInfo.getId())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("id").as(String.class),channelInfo.getId()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelName())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("channelName").as(String.class),"%"+channelInfo.getChannelName()+"%"));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelDescribe())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("channelDescribe").as(String.class),"%"+channelInfo.getChannelDescribe()+"%"));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelPlatform())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("channelPlatform").as(String.class),channelInfo.getChannelPlatform()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelType())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("channelType").as(Integer.class),channelInfo.getChannelType()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getImg())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("img").as(String.class),"%"+channelInfo.getImg()+"%"));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelGeneralize())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("channelGeneralize").as(Integer.class),channelInfo.getChannelGeneralize()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelOnepoint())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("channelOnepoint").as(Integer.class),channelInfo.getChannelOnepoint()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelUsing())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("channelUsing").as(Integer.class),channelInfo.getChannelUsing()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getChannelPriRecommend())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("channelPriRecommend").as(Integer.class),channelInfo.getChannelPriRecommend()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getContent())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("content").as(String.class),"%"+channelInfo.getContent()+"%"));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getPackageName())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("packageName").as(String.class),channelInfo.getPackageName()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getUrl())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("url").as(String.class),"%"+channelInfo.getUrl()+"%"));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getCreateBy())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("createBy").as(Integer.class),channelInfo.getCreateBy()));
            }
            if(!ObjectUtils.isEmpty(channelInfo.getUpdateBy())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("updateBy").as(Integer.class),channelInfo.getUpdateBy()));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}