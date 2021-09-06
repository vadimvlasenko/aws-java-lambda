package com.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class CoreModule {

    @Singleton
    @Provides
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
