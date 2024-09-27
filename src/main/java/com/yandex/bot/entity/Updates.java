package com.yandex.bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Updates {
    private ArrayList<Update> updates;

}
