package com.example.hexagonal.domain.port.out;

import com.example.hexagonal.domain.model.Item;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepositoryPort {
    Item save(Item item);
    Optional<Item> findById(UUID id);
}
