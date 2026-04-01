package com.example.hexagonal.application.service;

import com.example.hexagonal.domain.model.Item;
import com.example.hexagonal.domain.port.out.ItemRepositoryPort;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

class ItemServiceTest {

    @Test
    void create_shouldPersistAndReturnItem() {
        ItemRepositoryPort fakeRepo = new ItemRepositoryPort() {
            private final Map<UUID, Item> db = new ConcurrentHashMap<>();

            @Override
            public Item save(Item item) {
                db.put(item.id(), item);
                return item;
            }

            @Override
            public Optional<Item> findById(UUID id) {
                return Optional.ofNullable(db.get(id));
            }
        };

        ItemService service = new ItemService(fakeRepo);
        Item created = service.create("Item A");

        assertThat(created.name()).isEqualTo("Item A");
        assertThat(service.getById(created.id())).isPresent();
    }
}
