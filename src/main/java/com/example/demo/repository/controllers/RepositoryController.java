package com.example.demo.repository.controllers;

import com.example.demo.repository.dto.RepositoryDto;
import com.example.demo.repository.services.RepositoryService;
import com.example.demo.utils.Constraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = Constraints.BASE_URL)
public class RepositoryController {

    private RepositoryService repositoryService;

    @Autowired
    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping(path = Constraints.GET_URL , produces = "application/json")
    public @ResponseBody CompletableFuture<RepositoryDto> findRepository
            (@PathVariable String owner, @PathVariable String repositoryName) {
        return repositoryService.findRepository(String.format(Constraints.URL_TEMPLATE, owner, repositoryName));
    }
}
