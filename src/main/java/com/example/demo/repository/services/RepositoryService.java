package com.example.demo.repository.services;

import com.example.demo.repository.dto.RepositoryDto;
import com.example.demo.repository.dto.ResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class RepositoryService {
    private final RestTemplate restTemplate;


    public RepositoryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.errorHandler(new DefaultResponseErrorHandler()).build();
    }

    @Async
    public CompletableFuture<ResponseDto> findRepository(String url) {
        ModelMapper modelMapper = new ModelMapper();
        return CompletableFuture.completedFuture(restTemplate.getForObject(url, RepositoryDto.class))
                .thenApply(result -> modelMapper.map(result, ResponseDto.class));
    }
}