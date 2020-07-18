package com.darren.dubbo.consumer;

import com.darren.dubbo.service.util.DateTools;
import org.junit.Test;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: darren-dubbo
 * Author : Eric
 * Time   : 2020-06-22 14:15
 * Desc   :  *
 */
public class CommonTest {

    @Test
    public void emptyList() {
        System.out.println(15 * 1000 * 1000 * 1000L);
        List<String> resources = new ArrayList<>();
        List<String> emptyList = Collections.emptyList();

        for (String resource : emptyList) {
            System.out.println(resource);
        }

    }

    @Test
    public void timeStampConvert() {
        long startTime = 1594297174308L;// 1593681580349 1593680418000 1594712331
        long interval = 1800000;

        System.out.println(DateTools.getCurrentMsecTimestamp());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(DateTools.getCurrentDateyyyyMMddhhmmss());
        System.out.println(DateTools.getCurrentDateYYYYMMDDHHMMSSsss());
        System.out.println(DateTools.getCurrentFormatDate());

        System.out.println("时间戳转日期：" + DateTools.stampToDate(startTime));
        System.out.println("日期转时间戳：" + DateTools.stringToDate("20200706113800", DateTools.FORMAT_MICROSECOND2).getTime());
    }

    @Test
    public void random() {
        for (int i = 0; i < 100; i++) {
            Integer randomId = new SecureRandom().nextInt(10);
            System.out.println(randomId);
        }
    }

    @Test
    public void nextMonitorTime() {
        // 获取每分钟的整分时间戳
        long now = System.currentTimeMillis();
        long time = now - now % (1000 * 60);
        System.out.println(time);
        System.out.println("时间戳转日期：" + DateTools.stampToDate(time));
    }


}
