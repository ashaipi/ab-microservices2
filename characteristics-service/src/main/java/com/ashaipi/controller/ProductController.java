package com.ashaipi.controller;

import com.ashaipi.dto.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class ProductController {

    private final WebClient webClient;

    public ProductController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://product-service") // This should match the expected service name
                .build();
    }

    @GetMapping("/allproducts")
    public Mono<List<Product>> getAllProducts() {
        return webClient.get()
                .uri("/allproducts")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {})
                .doOnError(WebClientResponseException.class, ex -> {
                    System.err.println("Error fetching products: " + ex.getResponseBodyAsString());
                });
    }

}
