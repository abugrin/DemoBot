package com.yandex.bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class From {
    private String id;
    private String display_name;
    private String login;
    private boolean robot;

}