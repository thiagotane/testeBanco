package com.example.testeSantander.dto;

import lombok.Value;

import java.util.List;

@Value
public class PageDTO<T> {

    private List<T> content;

    private long totalElements;
}