package com.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.errors.JsonSerializeException;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Slf4j
public class JsonService {
    private final ObjectMapper objectMapper;

    @Inject
    public JsonService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String toJson(Object model) {
        try {
            return objectMapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            log.error("Cannot serialize to JSON: {}", model);
            throw new JsonSerializeException(e.getMessage(), e);
        }
    }
}
