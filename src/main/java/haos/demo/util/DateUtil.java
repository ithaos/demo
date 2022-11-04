package haos.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.Instant;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtil<R, T> {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    public R calc(T t) {
//
//        Date start = Instant.now().toDate();
//        log.info("work start time {}", sdf.format(start));
//
//
//
//        Date end = Instant.now().toDate();
//        log.info("work end time {}", sdf.format(end));
//        log.info("耗时: {}", (end.getTime() - start.getTime()) / 1000 + "ms");
//
//        return R;
//    }
}
