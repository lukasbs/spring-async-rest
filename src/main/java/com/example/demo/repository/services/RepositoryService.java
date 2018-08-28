package com.example.demo.repository.services;

import com.example.demo.repository.dto.RepositoryDto;
import com.example.demo.repository.dto.ResponseDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class RepositoryService {
    private static final Logger logger = LoggerFactory.getLogger(RepositoryService.class);
    private final RestTemplate restTemplate;

    public RepositoryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.errorHandler(new DefaultResponseErrorHandler()).build();
    }

    @Async
    public CompletableFuture<ResponseDto> findRepository(String url) {
        logger.info("Looking up " + url);
        ModelMapper modelMapper = new ModelMapper();
        RepositoryDto repositoryDto = restTemplate.getForObject(url, RepositoryDto.class);
        return CompletableFuture.completedFuture(repositoryDto).thenApply(result -> modelMapper.map(result, ResponseDto.class));
    }
}