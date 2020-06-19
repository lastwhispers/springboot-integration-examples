package cn.lastwhisper.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置信息实体类
 * @author lastwhisper
 * @date 2020-05-25
 */
@ConfigurationProperties("formatter")
public class DateFormatProperties {

    /**
     * default format pattern
     */
    private String pattern = "yyyy-MM-dd HH:mm:ss";

    // 忽略 getter setter

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
