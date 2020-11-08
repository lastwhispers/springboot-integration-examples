package cn.cunchang.handler;

import io.github.notoday.dingtalk.robot.DingRobotHelper;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DingTalkHandler {

    private static final ConcurrentHashMap<String, DingRobotHelper> dingTalkClientCache = new ConcurrentHashMap<>();

    public static DingRobotHelper getDingRobotHelper(String token, String secret) {
        DingRobotHelper dingRobotHelper = dingTalkClientCache.get(token);
        if (Objects.isNull(dingRobotHelper)) {
            dingRobotHelper = new DingRobotHelper(token, secret);
            dingTalkClientCache.put(token, dingRobotHelper);
        }
        return dingRobotHelper;
    }
}