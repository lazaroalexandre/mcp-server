package com.example.mpc_server.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record ProductDtoRegister(String name,
        String description,
        Double price) {
    
}
