package com.yandex.bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Chat {
    public static final String GROUP = "group";
    public static final String PRIVATE = "private";

    private String type;
    private String id;

}