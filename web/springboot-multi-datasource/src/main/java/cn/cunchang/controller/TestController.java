package cn.cunchang.controller;

import cn.cunchang.mapper.db1.GoodsMapper;
import cn.cunchang.mapper.db2.MerchantMapper;
import cn.cunchang.pojo.Goods;
import cn.cunchang.pojo.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cunchang
 * @date 2020/12/25 12:32 上午
 */
@RestController
public class TestController {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * http://localhost:8080/db1?id=1
     * @param id
     * @return
     */
    @RequestMapping("db1")
    public Goods db1(@RequestParam Long id) {
        return goodsMapper.findById(id);
    }

    /**
     * http://localhost:8080/db2?id=1
     * @param id
     * @return
     */
    @RequestMapping("db2")
    public Merchant db2(@RequestParam Long id) {
        return merchantMapper.findById(id);
    }

}
