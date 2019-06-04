package dream.work.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

<<<<<<< HEAD:eladmin-logging/src/main/java/me/zhengjie/service/LogService.java
import javax.servlet.http.HttpServletRequest;
=======
import dream.work.domain.Log;
>>>>>>> dreamWorkAdmin init:admin-logging/src/main/java/dream/work/service/LogService.java

/**
 * @author jie
 * @date 2018-11-24
 */
public interface LogService {

    /**
     * 新增日志
     * @param joinPoint
     * @param log
     */
    @Async
    void save(String username, String ip, ProceedingJoinPoint joinPoint, Log log);

    /**
     * 查询异常详情
     * @param id
     * @return
     */
    Object findByErrDetail(Long id);
}
