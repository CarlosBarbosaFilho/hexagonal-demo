package com.example.hexagonal.application.service;

import com.example.hexagonal.domain.model.Item;
import com.example.hexagonal.domain.port.in.CreateItemUseCase;
import com.example.hexagonal.domain.port.in.GetItemUseCase;
import com.example.hexagonal.domain.port.out.ItemRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService implements CreateItemUseCase, GetItemUseCase {

    private final ItemRepositoryPort repository;

    public ItemService(ItemRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Item create(String name) {
        Item item = new Item(UUID.randomUUID(), name);
        return repository.save(item);
    }

    @Override
    public Optional<Item> getById(UUID id) {
        return repository.findById(id);
    }
}
