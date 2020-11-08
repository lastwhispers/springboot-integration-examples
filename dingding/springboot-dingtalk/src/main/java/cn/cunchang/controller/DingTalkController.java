package cn.cunchang.controller;


import cn.cunchang.controller.req.DingAtReq;
import cn.cunchang.service.DingDingService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
public class DingTalkController {

    @Autowired
    private DingDingService dingDingService;

    @PostMapping(value = "/ding/at")
    public void dingAt(HttpServletRequest request, @Valid @RequestBody DingAtReq dingAtReq) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            log.warn("@钉钉机器人,token为空");
        }
        log.info("@钉钉机器人header:{}", JSONObject.toJSONString(request.getHeaderNames()));
        log.info("@钉钉机器人body:{}", JSONObject.toJSONString(dingAtReq));
        dingDingService.dingAt(token, dingAtReq);
    }

}
