package cn.lastwhisper;

import cn.lastwhisper.autoconfigure.DateFormatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 * @author lastwhisper
 * @date 2020/6/10
 */
@RestController
public class DemoController {

    @Autowired
    private DateFormatHandler dateFormatHandler;

    @RequestMapping("/date")
    public String date() {
        return dateFormatHandler.format(new Date());
    }


}
