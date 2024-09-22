package com.deutsche.telco.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;

@Slf4j
@Component
public class DateUtil {

    public static Timestamp addMinutesToCurrentTimeStamp(int minutes){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now.getTime());
        calendar.add(Calendar.MINUTE, minutes);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Long getTimeStampDiffInMin(Timestamp start, Timestamp end){
        long diffInMillis = end.getTime() - start.getTime();
        long diffInMinutes = diffInMillis / (1000 * 60);
        return diffInMinutes;
    }

    public static Long getTimeStampDiffInDays(Timestamp start, Timestamp end){
        long diffInMillis = end.getTime() - start.getTime();
        long diffInDays = diffInMillis / (1000 * 60*60*24);
        return diffInDays;
    }
}
