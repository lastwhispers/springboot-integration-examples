package cn.cunchang.controller.req;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@Data
public class DingAtReq {

    /**
     * {
     * "conversationId":"cidxEkHbDdHC0LQeXFa92vBtg==",
     * "atUsers":[
     * {
     * "dingtalkId":"$:LWCP_v1:$Ocv0788sBJcH1Rldeh1MdHSly1yIc5Bo"
     * }
     * ],
     * "chatbotUserId":"$:LWCP_v1:$Ocv0788sBJcH1Rldeh1MdHSly1yIc5Bo",
     * "msgId":"msgUsqT1qDtQIPPuj1Liq39RA==",
     * "senderNick":"寸长",
     * "isAdmin":false,
     * "sessionWebhookExpiredTime":1604305420458,
     * "createAt":1604300020416,
     * "conversationType":"2",
     * "senderId":"$:LWCP_v1:$f3SpARvbgxWEzAfOA5w+K+QHKxqeweOJ",
     * "conversationTitle":"支行查询优化",
     * "isInAtList":true,
     * "sessionWebhook":"https://oapi.dingtalk.com/robot/sendBySession?session=a91fc85235112e4ac3d7f3a785ce86d1",
     * "text":{
     * "content":" 哈哈哈哈哈"
     * },
     * "msgtype":"text"
     * }
     */

    private String conversationId;
    private String chatbotUserId;
    private String msgId;

    @NotBlank(message = "钉钉机器人入参：发送人姓名")
    private String senderNick;

    private Boolean isAdmin;
    private Long sessionWebhookExpiredTime;
    private Long createAt;
    private String conversationType;
    private String senderId;
    private String conversationTitle;
    private Boolean isInAtList;
    private String sessionWebhook;

    @NotNull(message = "钉钉机器人入参：at的信息")
    private TextDTO text;

    private String msgtype;
    private List<AtUsersDTO> atUsers;

    @NoArgsConstructor
    @Data
    public static class TextDTO {
        private String content;
    }

    @NoArgsConstructor
    @Data
    public static class AtUsersDTO {

        private String dingtalkId;
    }

}




