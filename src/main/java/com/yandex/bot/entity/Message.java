package com.yandex.bot.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    private String login;
    private String text;
    private String chat_id;
    private String thread_id;
    private Button[] inline_keyboard;
    private boolean disable_web_page_preview = true;

}
