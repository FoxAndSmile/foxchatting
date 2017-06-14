package com.foxandsmile.foxchatting.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by h9x43hd834h on 2017-06-14.
 */
@Component
public class Producer {
    @Autowired
    SimpMessagingTemplate template;

    public void sendMessageTo(String topic, String message) {

        // 목적지 topic에 메세지를 보내는 역할을 합니다.
        this.template.convertAndSend("/chat/" + topic, message);
    }
}
