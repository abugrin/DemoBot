package com.yandex.bot.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:bot.properties")
@ConfigurationProperties(prefix = "bot")

@Getter
@Setter
public class PropertiesConfiguration {
    private String token;

}
