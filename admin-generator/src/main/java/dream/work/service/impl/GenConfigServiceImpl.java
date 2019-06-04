package dream.work.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dream.work.domain.GenConfig;
import dream.work.repository.GenConfigRepository;
import dream.work.service.GenConfigService;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-01-14
 */
@Service
public class GenConfigServiceImpl implements GenConfigService {

    @Autowired
    private GenConfigRepository genConfigRepository;

    @Override
    public GenConfig find() {
        Optional<GenConfig> genConfig = genConfigRepository.findById(1L);
        if(genConfig.isPresent()){
            return genConfig.get();
        } else {
            return new GenConfig();
        }
    }

    @Override
    public GenConfig update(GenConfig genConfig) {
        genConfig.setId(1L);
        return genConfigRepository.save(genConfig);
    }
}
