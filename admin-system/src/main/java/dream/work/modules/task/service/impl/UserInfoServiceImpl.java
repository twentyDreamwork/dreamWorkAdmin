package dream.work.modules.task.service.impl;

import dream.work.modules.task.domain.UserInfo;
import dream.work.utils.ValidationUtil;
import dream.work.modules.task.repository.UserInfoRepository;
import dream.work.modules.task.service.UserInfoService;
import dream.work.modules.task.service.dto.UserInfoDTO;
import dream.work.modules.task.service.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import cn.hutool.core.util.IdUtil;

/**
* @author Yang
* @date 2019-06-22
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoDTO findById(String id) {
        Optional<UserInfo> userInfo = userInfoRepository.findById(id);
        ValidationUtil.isNull(userInfo,"UserInfo","id",id);
        return userInfoMapper.toDto(userInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDTO create(UserInfo resources) {
        resources.setId(IdUtil.simpleUUID()); 
        return userInfoMapper.toDto(userInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserInfo resources) {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalUserInfo,"UserInfo","id",resources.getId());

        UserInfo userInfo = optionalUserInfo.get();
        // 此处需自己修改
        resources.setId(userInfo.getId());
        userInfoRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        userInfoRepository.deleteById(id);
    }
}