package com.yandex.bot.example;

import com.yandex.bot.client.BotClient;
import com.yandex.bot.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("text")
public class TextHandler implements Handler {
    private BotClient botClient;

    @Autowired
    public void setBotClient(BotClient botClient) {
        this.botClient = botClient;
    }

    @Override
    public void handle(Update update) {
        long messageId;
        messageId = botClient.sendText(update.getText(), update);
        log.info("Message ID: {}", messageId);
        messageId = botClient.sendButtons(update.getText(), getMenu(), update);
        log.info("Message ID: {}", messageId);
    }


    private Button[] getMenu() {
        Button helpButton = new Button();
        MyCB data = new MyCB();
        data.setCmd("/help");
        helpButton.setText("Help");
        helpButton.setCallback_data(data);
        return new Button[]{helpButton};
    }

}
