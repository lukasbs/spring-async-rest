package com.example.demo.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ResponseDto {

    @JsonProperty("fullName")
    private String name;
    private String description;
    private String cloneUrl;
    @JsonProperty("stars")
    private int stargazersCount;
    private Date createdAt;
}
