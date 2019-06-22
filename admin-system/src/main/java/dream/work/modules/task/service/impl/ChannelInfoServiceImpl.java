package dream.work.modules.task.service.impl;

import dream.work.modules.task.domain.ChannelInfo;
import dream.work.utils.ValidationUtil;
import dream.work.modules.task.repository.ChannelInfoRepository;
import dream.work.modules.task.service.ChannelInfoService;
import dream.work.modules.task.service.dto.ChannelInfoDTO;
import dream.work.modules.task.service.mapper.ChannelInfoMapper;
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
public class ChannelInfoServiceImpl implements ChannelInfoService {

    @Autowired
    private ChannelInfoRepository channelInfoRepository;

    @Autowired
    private ChannelInfoMapper channelInfoMapper;

    @Override
    public ChannelInfoDTO findById(String id) {
        Optional<ChannelInfo> channelInfo = channelInfoRepository.findById(id);
        ValidationUtil.isNull(channelInfo,"ChannelInfo","id",id);
        return channelInfoMapper.toDto(channelInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChannelInfoDTO create(ChannelInfo resources) {
        resources.setId(IdUtil.simpleUUID()); 
        return channelInfoMapper.toDto(channelInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ChannelInfo resources) {
        Optional<ChannelInfo> optionalChannelInfo = channelInfoRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalChannelInfo,"ChannelInfo","id",resources.getId());

        ChannelInfo channelInfo = optionalChannelInfo.get();
        // 此处需自己修改
        resources.setId(channelInfo.getId());
        channelInfoRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        channelInfoRepository.deleteById(id);
    }
}