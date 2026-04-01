package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.Item;

import java.util.Optional;
import java.util.UUID;

public interface GetItemUseCase {
    Optional<Item> getById(UUID id);
}
