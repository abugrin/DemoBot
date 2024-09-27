package com.yandex.bot.service;

import com.yandex.bot.entity.Handler;
import com.yandex.bot.entity.Update;
import com.yandex.bot.entity.Updates;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class DemoBotService {
    private final Map<String, Handler> handlers = new HashMap<>();

    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {

        try {
            handlers.put("text", (Handler) applicationContext.getBean("text"));
            handlers.put("button", (Handler) applicationContext.getBean("button"));
        } catch (NoSuchBeanDefinitionException e) {
            log.error("No handler found for: {}", e.getMessage());
        }
    }

    public void onUpdates(Updates updates) {
        for (Update update : updates.getUpdates()) {
            Handler handler = handlers.get("text");
            log.info("Update {}", update.getUpdate_id());
            handler.handle(update);
        }
    }

}
