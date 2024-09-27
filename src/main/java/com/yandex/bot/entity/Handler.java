package com.yandex.bot.entity;

@FunctionalInterface
public interface Handler {
    void handle(Update update);
}
