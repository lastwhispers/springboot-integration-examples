package cn.cunchang.config.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cunchang
 */
public class DataSourceConstants {


    public static final String MYBATIS_CONFIG_LOCATION = "classpath:mybatis.xml";


    /************************************包配置************************************/

    public static final String DB1_MAPPER_PACKAGE = "cn.cunchang.mapper.db1";

    public static final String DB2_MAPPER_PACKAGE = "cn.cunchang.mapper.db2";



    @Getter
    @AllArgsConstructor
    public enum DataSourceEnum {

        DB1("数据库1", "classpath:mapper/db1/*.xml", "spring.datasource.db1."),

        DB2("数据库2", "classpath:mapper/db2/*.xml", "spring.datasource.db2.");

        private String desc;
        private String xmlPath;
        private String prefix;
    }
}