package cn.cunchang.pojo;

import lombok.Data;

/**
 * @author cunchang
 * @date 2020/12/25 12:38 上午
 */
@Data
public class Merchant {

    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;
}
