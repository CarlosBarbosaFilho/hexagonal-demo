package com.example.hexagonal.domain.exception;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(UUID id) {
        super("Item não encontrado: " + id);
    }
}
