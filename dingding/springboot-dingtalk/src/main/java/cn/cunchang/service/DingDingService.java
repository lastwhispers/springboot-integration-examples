package cn.cunchang.service;

import cn.cunchang.controller.req.DingAtReq;
import cn.cunchang.manager.DingTalkManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
@Slf4j
public class DingDingService {

    @Autowired
    private DingTalkManager dingTalkManager;

    @Autowired
    private QaService qaService;

    @Autowired
    private HrService hrService;

    public void dingAt(String token, DingAtReq dingAtReq) {
        String content = dingAtReq.getText().getContent();
        if (StringUtils.isEmpty(content)) {
            log.warn("@钉钉机器人,输入为空:{}", content);
            return;
        }
        // @的时候会有空格，需要注意
        content = content.trim();
        String answer = qaService.answer(content);
        if (Objects.isNull(answer)) {
            log.warn("@钉钉机器人,问题:{} 找不到答案", answer);
            return;
        }
        String senderNick = dingAtReq.getSenderNick().trim();

        String mobile = hrService.getMobileByNick(senderNick);
        if (Objects.isNull(mobile)) {
            log.warn("@钉钉机器人,昵称:{} 查询不到对应员工", senderNick);
            return;
        }

        StringBuilder contextSb = new StringBuilder();
        contextSb.append(answer).append("\n");
        contextSb.append("@").append(mobile).append("\n");

        dingTalkManager.atUser(contextSb.toString(), token, mobile);
    }

}
