package com.example.mpc_server.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.mpc_server.dto.ProductDtoDetail;
import com.example.mpc_server.dto.ProductDtoRegister;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class McpClient {
    private final WebClient webClient;

    public McpClient(WebClient.Builder builder){
        webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public Flux<ProductDtoDetail> listAllProducts(){
        return webClient.get().uri("/product/list")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(ProductDtoDetail.class);
    }

    public Mono<ProductDtoRegister> registerOneProduct(ProductDtoRegister productDtoRegister){
        return webClient.post().uri("/product/register")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(productDtoRegister)
        .retrieve()
        .bodyToMono(ProductDtoRegister.class);
    }


}
