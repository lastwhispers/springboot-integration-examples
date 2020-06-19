package cn.lastwhisper.autoconfigure;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日期器
 * @author lastwhisper
 * @date 2020-05-25
 */
public class DateFormatHandler {

    private String pattern;

    public DateFormatHandler(String pattern) {
        this.pattern = pattern;
    }

    public String format(Date date) {
        // 每次 new 线程安全
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }


}