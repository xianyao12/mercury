package com.galaxy.mercury.common.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/8/3 22:47
 * <p>
 * EnableWebSocketMessageBroker: 开启websocket消息代理
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private static final long HEART_BEAT = 10000;

    @Override
    public void configureMessageBroker(@NotNull MessageBrokerRegistry registry) {
        ThreadPoolTaskScheduler task = new ThreadPoolTaskScheduler();
        task.setPoolSize(10);
        task.setThreadNamePrefix("wss-heartbeat-thread-");
        task.initialize();
        //public:公共频道，private:私人频道
        //注册 + 设置心跳检测
        registry.enableSimpleBroker("/public", "/private").setHeartbeatValue(new long[]{HEART_BEAT, HEART_BEAT}).setTaskScheduler(task);
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(@NotNull StompEndpointRegistry registry) {
        //.setAllowedOrigins("*") //跨域设置
        registry.addEndpoint("/chat").withSockJS();
    }
}
