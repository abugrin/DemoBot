package com.yandex.bot.example;

import com.yandex.bot.entity.CallBackData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyCB extends CallBackData {
    private String cmd;
}
