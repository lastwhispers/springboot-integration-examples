package cn.cunchang.pojo;

import lombok.Data;

/**
 * @author cunchang
 * @date 2020/12/25 12:38 上午
 */
@Data
public class Goods {

    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 分
     */
    private Long price;
}
