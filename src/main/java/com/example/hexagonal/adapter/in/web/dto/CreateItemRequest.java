package com.example.hexagonal.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateItemRequest(@NotBlank(message = "name é obrigatório") String name) {}
