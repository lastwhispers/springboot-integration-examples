package cn.lastwhisper.controller;

import cn.lastwhisper.util.AddressInMemoryUtil;
import cn.lastwhisper.util.HttpContext;
import org.lionsoul.ip2region.DataBlock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lastwhisper
 * @date 2020/5/31
 */
@Controller
public class LoginController {

    /**
     *  假装用户登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public DataBlock login() {
        String ip = HttpContext.getIp();
        DataBlock dataBlock = AddressInMemoryUtil.getCityInfo(ip);
        System.out.println(dataBlock);
        return dataBlock;
    }


}
