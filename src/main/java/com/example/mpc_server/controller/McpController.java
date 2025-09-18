package com.example.mpc_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mpc_server.client.McpClient;
import com.example.mpc_server.dto.ListProductDto;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class McpController {

    private McpClient mcpClient;
    
    @GetMapping("/product/list")
    public Flux<ListProductDto> listAllProducts(){
        return mcpClient.listAllProducts();
    }
}
