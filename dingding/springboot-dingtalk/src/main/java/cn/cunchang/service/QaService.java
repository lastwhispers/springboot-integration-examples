package cn.cunchang.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QaService {

    /**
     *  人工智能核心代码，将疑问句变成陈述句
     * @param question
     * @return
     */
    public String answer(String question) {
        // 模拟查库、调远程api
        question = question.replace("吗", "");
        question = question.replace("？", "!");
        question = question.replace("?", "!");
        return question;
    }

}
