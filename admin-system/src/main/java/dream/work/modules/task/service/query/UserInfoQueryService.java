package dream.work.modules.task.service.query;

import dream.work.utils.PageUtil;
import dream.work.modules.task.domain.UserInfo;
import dream.work.modules.task.service.dto.UserInfoDTO;
import dream.work.modules.task.repository.UserInfoRepository;
import dream.work.modules.task.service.mapper.UserInfoMapper;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "userInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserInfoQueryService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(UserInfoDTO userInfo, Pageable pageable){
        Page<UserInfo> page = userInfoRepository.findAll(new Spec(userInfo),pageable);
        return PageUtil.toPage(page.map(userInfoMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(UserInfoDTO userInfo){
        return userInfoMapper.toDto(userInfoRepository.findAll(new Spec(userInfo)));
    }

    class Spec implements Specification<UserInfo> {

        private UserInfoDTO userInfo;

        public Spec(UserInfoDTO userInfo){
            this.userInfo = userInfo;
        }

        @Override
        public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(userInfo.getId())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("id").as(String.class),userInfo.getId()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getUsername())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("username").as(String.class),"%"+userInfo.getUsername()+"%"));
            }
            if(!ObjectUtils.isEmpty(userInfo.getAccount())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("account").as(String.class),"%"+userInfo.getAccount()+"%"));
            }
            if(!ObjectUtils.isEmpty(userInfo.getPassword())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("password").as(String.class),userInfo.getPassword()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getEmail())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("email").as(String.class),"%"+userInfo.getEmail()+"%"));
            }
            if(!ObjectUtils.isEmpty(userInfo.getPhone())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("phone").as(String.class),"%"+userInfo.getPhone()+"%"));
            }
            if(!ObjectUtils.isEmpty(userInfo.getHisPoint())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("hisPoint").as(Long.class),userInfo.getHisPoint()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getPoint())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("point").as(Long.class),userInfo.getPoint()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getGeneralize())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("generalize").as(Integer.class),userInfo.getGeneralize()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getInvite())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("invite").as(String.class),userInfo.getInvite()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getMoney())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("money").as(Integer.class),userInfo.getMoney()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getCreateBy())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("createBy").as(Integer.class),userInfo.getCreateBy()));
            }
            if(!ObjectUtils.isEmpty(userInfo.getUpdateBy())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("updateBy").as(Integer.class),userInfo.getUpdateBy()));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}