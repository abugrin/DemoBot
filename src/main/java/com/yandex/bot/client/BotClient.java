package com.yandex.bot.client;

import com.yandex.bot.entity.TextMessage;
import com.yandex.bot.entity.Updates;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bot-client", url= "https://botapi.messenger.yandex.net/bot/v1")
//@Headers("Authorization: OAuth y0_AgAAAAB3SFZbAATIlgAAAAEKDSe-AABnQ4jdfHZDr7xwnny_5zLNWUXR3A")
public interface BotClient {

    @RequestMapping(method = RequestMethod.POST, value = "/messages/sendText/", produces = "application/json")
    //@Headers("Authorization: OAuth y0_AgAAAAB3SFZbAATIlgAAAAEKDSe-AABnQ4jdfHZDr7xwnny_5zLNWUXR3A")
    //@RequestLine("POST /messages/sendText/")
    void sendText(@RequestHeader("Authorization") String token, TextMessage message);
}