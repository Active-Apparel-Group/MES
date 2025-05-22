package com.longson.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class UtilsTime {

    private static final String DATE_FORMAT = "yyyyMMddHHmmss";
    public static long getTime(String oldtime,String newTime) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long NTime =df.parse(newTime).getTime();
        //从对象中拿到时间
        long OTime = df.parse(oldtime).getTime();
        long diff=(NTime-OTime)/1000/60;
        return diff;
    }

   // UUID（Universally Unique Identifier）是一种通用唯一标识符，其值在所有设备和时间上都是唯一的。Java提供了UUID类，可以用于生成不重复的编号。
        public static String generateId() {
            UUID uuid = UUID.randomUUID();
            return  "A"+uuid.toString();
        }



    //AtomicInteger是Java提供的线程安全的原子整数类，它可以用于生成不重复的递增编号。

        public static String  getorderId(){
            long timestamp = System.currentTimeMillis();
            final AtomicInteger counter = new AtomicInteger(0);
             SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            return "MES"+dateFormat.format(new Date(timestamp))+ String.valueOf(counter.incrementAndGet());
        }



}
