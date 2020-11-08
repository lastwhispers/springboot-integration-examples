package cn.cunchang.manager;

import cn.cunchang.handler.DingTalkHandler;
import io.github.notoday.dingtalk.robot.DingRobotHelper;
import io.github.notoday.dingtalk.robot.message.TextMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class DingTalkManager {

    private final Map<String, Robot> groupRobotMap = new HashMap<>();

    {
        // 银行选择问题加急群
        Robot robot1 = new Robot();
        robot1.setToken("ffb590d27694dabbb9b1e0ec42a3bcf292c5cd64af361a0949cf8d96602f7a8f");
        robot1.setSecret("SECb4ec20b1deb5780e8b14102d25dc56a01a092e7a277b8f068d2e3dde66593ed9");
        groupRobotMap.put("tokenhhhhhhh", robot1);
    }


    /**
     * 推送回答信息，并艾特用户
     *
     * @param content 内容
     * @param token   机器人
     * @param mobile  @的用户
     */
    @Async()
    public void atUser(String content, String token, String mobile) {
        Robot robot = groupRobotMap.get(token);
        if (Objects.isNull(robot)) {
            log.warn("检查token:[{}] 是否存在", token);
            return;
        }
        DingRobotHelper dingRobotHelper = DingTalkHandler.getDingRobotHelper(robot.token, robot.secret);

        TextMessage textMessage = TextMessage.builder().content(content).at(mobile).build();
        dingRobotHelper.sendMessage(textMessage);
    }

    @EqualsAndHashCode
    @Data
    private static class Robot {
        private String token;
        private String secret;
    }

}
