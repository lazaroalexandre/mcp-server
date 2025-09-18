package com.example.mpc_server.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record ProductDto(
        String id,
        String name,
        String description,
        Double price) {
}
