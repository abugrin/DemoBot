package com.yandex.bot.service;

import com.yandex.bot.client.BotClient;
import com.yandex.bot.entity.TextMessage;
import com.yandex.bot.entity.Update;
import com.yandex.bot.entity.Updates;
import com.yandex.bot.example.UpdateHandlers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

@Service
public class DemoBotService {
    //private BotClient botClient;
    private UpdateHandlers updateHandlers;
    private MethodHandle sendTextMH;

    @Autowired
    /*public void setBotClient(BotClient botClient) {
        this.botClient = botClient;
    }*/
    public void setBotUpdateHandlers(UpdateHandlers updateHandlers) {
        this.updateHandlers = updateHandlers;
    }

    public DemoBotService() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            Method sendTextMethod = UpdateHandlers.class.getDeclaredMethod("onText", Update.class);
            sendTextMethod.setAccessible(true);

            sendTextMH = lookup.unreflect(sendTextMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void onUpdates(Updates updates) {
        try {
            sendTextMH.invoke("onText", updates.getUpdates().getFirst());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        /*
        TextMessage message = new TextMessage();
        message.setLogin("abugrin@myandex360.ru");
        message.setText("Hello!");
        String token = "OAuth y0_AgAAAAB4-MyuAATIlgAAAAESLd6DAABVBlsyG1FMFI8kZLoZeP7NSXAzLw";
        botClient.sendText(token, message);
        */
    }



}
