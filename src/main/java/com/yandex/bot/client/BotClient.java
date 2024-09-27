package com.yandex.bot.client;

import com.yandex.bot.entity.*;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
public class BotClient {
    @Value("${bot.token}")
    private String token;

    private RestClient restClient;

    @PostConstruct
    public void init() {
        restClient = RestClient.builder()
                .baseUrl("https://botapi.messenger.yandex.net/bot/v1")
                .defaultHeaders(httpHeaders -> httpHeaders.set("Authorization", "OAuth " + token)).build();
    }

    public long sendText(String text, Update update) {
        Message message = new Message();
        message.setText(text);
        return sendMessage(message, update);
    }

    public long sendButtons(String text, Button[] buttons, Update update) {
        Message message = new Message();
        message.setText(text);
        message.setInline_keyboard(buttons);
        return sendMessage(message, update);
    }

    private long sendMessage(Message message, Update update) {
        MessageResponse response;
        if (update.getChat().getType().equals(Chat.GROUP)) {
            message.setChat_id(update.getChat().getId());
        } else {
            message.setLogin(update.getFrom().getLogin());
        }
        try {
            response = restClient.post()
                    .uri("/messages/sendText/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(message)
                    .retrieve()
                    .body(MessageResponse.class);
        } catch (HttpClientErrorException e) {
            response = new MessageResponse();
            response.setCode(e.getStatusCode().toString());
            response.setOk(false);
            response.setDescription(e.getResponseBodyAsString());
            response.setMessage_id(0);
        }

        assert response != null;
        if (response.isOk()) {
            log.info("Message send success: {}", response.getMessage_id());
        } else {
            log.error("Message send error: {} {} ", response.getCode(), response.getDescription());
        }

        return response.getMessage_id();
    }
}

