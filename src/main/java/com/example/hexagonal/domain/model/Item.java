package com.example.hexagonal.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Item {

    private final UUID id;
    private final String name;

    public Item(UUID id, String name) {
        this.id = Objects.requireNonNull(id, "id é obrigatório");
        this.name = Objects.requireNonNull(name, "name é obrigatório");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name não pode ser vazio");
        }
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }
}
