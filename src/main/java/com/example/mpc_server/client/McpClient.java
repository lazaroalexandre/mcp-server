package com.example.mpc_server.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.mpc_server.dto.ListProductDto;

import reactor.core.publisher.Flux;

@Service
public class McpClient {
    private final WebClient webClient;

    public McpClient(WebClient.Builder builder){
        webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public Flux<ListProductDto> listAllProducts(){
        return webClient.get().uri("/product/list")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(ListProductDto.class);
    }


}
