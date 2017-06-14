package com.foxandsmile.foxchatting.controller;

import com.foxandsmile.foxchatting.socket.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by h9x43hd834h on 2017/06/11.
 */
@Controller
public class ChatController {
    @Autowired
    Producer producer;

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String index(Model model) {
        return "chat/chat";
    }

    /**
     *
     * @param topic : /message, 원하는 path
     * @param message
     * @return
     */
    @RequestMapping("/send/{topic}")
    public @ResponseBody
    String sender(@PathVariable String topic, @RequestParam String message) {
        // /topic/ + {_topic}로 메세지를 전송합니다.
        producer.sendMessageTo(topic, message);
        return "OK";
    }
}
