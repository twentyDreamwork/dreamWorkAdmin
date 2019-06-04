package dream.work.modules.quartz.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dream.work.modules.monitor.service.VisitsService;

/**
 * @author jie
 * @date 2018-12-25
 */
@Component
public class VisitsTask {

    @Autowired
    private VisitsService visitsService;

    public void run(){
        visitsService.save();
    }
}
