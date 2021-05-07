package cn.cunchang.config.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cunchang
 */
public class DataSourceConstants {


    public static final String MYBATIS_CONFIG_LOCATION = "classpath:mybatis.xml";


    /**
     * mapper 包扫描
     */
    public static final String DB1_MAPPER_PACKAGE = "cn.cunchang.mapper.db1";
    public static final String DB2_MAPPER_PACKAGE = "cn.cunchang.mapper.db2";

    /**
     * DataSource 初始化前缀
     */
    public static final String DB1_PREFIX = "spring.datasource.rds1";
    public static final String DB2_PREFIX = "spring.datasource.rds2";


    @Getter
    @AllArgsConstructor
    public enum DataSourceEnum {

        DB1("数据库1", "classpath:mapper/db1/*.xml"),

        DB2("数据库2", "classpath:mapper/db2/*.xml"),



        ;

        private String desc;
        private String xmlPath;
    }
}