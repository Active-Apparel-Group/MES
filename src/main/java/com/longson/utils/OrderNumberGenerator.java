package com.longson.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 获取生成订单编号、单据编号 、通用方法
 */

public class OrderNumberGenerator {

        private static final String PREFIX = "MRPSSOI";
        private static final String DATE_FORMAT = "yyyyMMddHHmmss";
        private static final int SEQUENCE_LENGTH = 4;

        private SimpleDateFormat dateFormat;
        private AtomicLong sequence;

        public OrderNumberGenerator() {
            dateFormat = new SimpleDateFormat(DATE_FORMAT);
            sequence = new AtomicLong(0);
        }

        public String generate() {
            long timestamp = System.currentTimeMillis();
            long seq = sequence.getAndIncrement() % (int) Math.pow(10, SEQUENCE_LENGTH);
            String number = String.format("%s%s%0" + SEQUENCE_LENGTH + "d", PREFIX, dateFormat.format(new Date(timestamp)), seq);
            return number;
        }
    }


