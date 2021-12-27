package com.productfeedersystem.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JsonXmlConfiguration {

        @Bean
        @Primary
        public ObjectMapper feederSystemObjectMapper() {
            return new ObjectMapper();
        }
}
