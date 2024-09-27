package com.yandex.bot.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Button {
    private String text;
    private CallBackData callback_data;
}
