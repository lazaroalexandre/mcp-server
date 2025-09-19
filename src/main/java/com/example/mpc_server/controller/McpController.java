package com.example.mpc_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mpc_server.client.McpClient;
import com.example.mpc_server.dto.ProductDtoDetail;
import com.example.mpc_server.dto.ProductDtoRegister;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class McpController {

    private McpClient mcpClient;
    
    @GetMapping("/product/list")
    public Flux<ProductDtoDetail> listAllProducts(){
        return mcpClient.listAllProducts();
    }

    @PostMapping("/product/register")
    public Mono<ProductDtoRegister> postOneProduct(@RequestBody ProductDtoRegister productDtoRegister){
        return mcpClient.registerOneProduct(productDtoRegister);
    }
}
