package com.yandex.bot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yandex.bot.entity.Updates;
import com.yandex.bot.service.DemoBotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoBotController  {
    private DemoBotService demoBotService;
    private final ObjectMapper mapper;

    public DemoBotController(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setDemoBotService(DemoBotService demoBotService) {
        this.demoBotService = demoBotService;
    }

    @PostMapping(value = "/api/bot")
    public ResponseEntity<String> onUpdates(@RequestBody Updates updates) throws JsonProcessingException {
        log.info("Request: {}", mapper.writeValueAsString(updates));
        demoBotService.onUpdates(updates);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}