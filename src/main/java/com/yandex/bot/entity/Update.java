package com.yandex.bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Update {
    private long message_id;
    private int timestamp;
    private Chat chat;
    private From from;
    private long update_id;
    private String text;
    private LinkedHashMap<String,Object> callback_data;
}

