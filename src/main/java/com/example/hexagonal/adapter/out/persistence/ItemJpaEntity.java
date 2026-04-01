package com.example.hexagonal.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemJpaEntity {

    @Id
    private UUID id;

    private String name;

    protected ItemJpaEntity() {
    }

    public ItemJpaEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
