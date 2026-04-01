package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.domain.model.Item;
import com.example.hexagonal.domain.port.out.ItemRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ItemRepositoryAdapter implements ItemRepositoryPort {

    private final SpringDataItemRepository repo;

    public ItemRepositoryAdapter(SpringDataItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public Item save(Item item) {
        ItemJpaEntity saved = repo.save(new ItemJpaEntity(item.id(), item.name()));
        return new Item(saved.getId(), saved.getName());
    }

    @Override
    public Optional<Item> findById(UUID id) {
        return repo.findById(id).map(e -> new Item(e.getId(), e.getName()));
    }
}
