package haos.demo.common.util.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint; //目标函数
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.joda.time.Instant;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class Timer {


    @Around("execution(public * haos.demo.redis_cache.QueryDataController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = Instant.now().toDate();
        log.info("----------------- query start time {} -----------------", sdf.format(start));

        Object ret = pjp.proceed();

        Date end = Instant.now().toDate();
        log.info("----------------- query end time {},耗时: {} -----------------", sdf.format(end), (end.getTime() - start.getTime()) / 1000 + "s");
        return ret;
    }

}
