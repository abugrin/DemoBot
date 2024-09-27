package com.yandex.bot.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TextMessage {
    private String login;
    private String text;
}
