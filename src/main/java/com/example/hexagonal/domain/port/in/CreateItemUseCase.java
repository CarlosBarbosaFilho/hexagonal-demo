package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.Item;

public interface CreateItemUseCase {
    Item create(String name);
}
