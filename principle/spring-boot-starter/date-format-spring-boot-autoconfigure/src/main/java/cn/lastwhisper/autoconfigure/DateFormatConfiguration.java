package cn.lastwhisper.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置信息实体类
 * @author lastwhisper
 * @date 2020-05-25
 */
@Configuration
@EnableConfigurationProperties(DateFormatProperties.class)
@ConditionalOnProperty(prefix = "formatter", name = "enabled", havingValue = "true")
public class DateFormatConfiguration {
    private DateFormatProperties dateFormatProperties;

    public DateFormatConfiguration(DateFormatProperties dateFormatProperties) {
        this.dateFormatProperties = dateFormatProperties;
    }

    @Bean
    public DateFormatHandler dateFormatHandler() {
        System.out.println("start to initialize DateFormatHandler with pattern: " + dateFormatProperties.getPattern());
        return new DateFormatHandler(dateFormatProperties.getPattern());
    }

}