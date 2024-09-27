package com.yandex.bot.example;

import com.yandex.bot.client.BotClient;
import com.yandex.bot.entity.TextMessage;
import com.yandex.bot.entity.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateHandlers {
    private BotClient botClient;
    @Autowired
    public void setBotClient(BotClient botClient) {
        this.botClient = botClient;
    }

    public void onText(Update update) {
        TextMessage message = new TextMessage();
        message.setLogin("abugrin@myandex360.ru");
        message.setText("Hello!");
        String token = "OAuth y0_AgAAAAB4-MyuAATIlgAAAAESLd6DAABVBlsyG1FMFI8kZLoZeP7NSXAzLw";
        botClient.sendText(token, message);
    }
}
