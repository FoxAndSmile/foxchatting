package com.foxandsmile.foxchatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by h9x43hd834h on 2017-06-14.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // /stomp로 endpoint를 설정했습니다. 차후 SockJs에서 이 endpoint를 사용합니다.
        stompEndpointRegistry.addEndpoint("/stomp").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 클라이언트가 /topic으로 시작하는 path로 접속하도록 설정
        registry.enableSimpleBroker("/chat");
//        registry.setApplicationDestinationPrefixes("/app");
        super.configureMessageBroker(registry);
    }
}
