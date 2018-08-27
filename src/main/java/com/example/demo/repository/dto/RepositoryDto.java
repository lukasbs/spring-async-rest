package com.example.demo.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RepositoryDto {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter @JsonProperty("clone_url")
    private String cloneUrl;
    @Getter @Setter @JsonProperty("stargazers_count")
    private int stargazersCount;
    @Getter @Setter @JsonProperty("created_at")
    private Date createdAt;
}
