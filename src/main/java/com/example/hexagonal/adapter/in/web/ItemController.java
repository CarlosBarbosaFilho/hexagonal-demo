package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.adapter.in.web.dto.CreateItemRequest;
import com.example.hexagonal.adapter.in.web.dto.ItemResponse;
import com.example.hexagonal.domain.exception.ItemNotFoundException;
import com.example.hexagonal.domain.model.Item;
import com.example.hexagonal.domain.port.in.CreateItemUseCase;
import com.example.hexagonal.domain.port.in.GetItemUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final CreateItemUseCase createItem;
    private final GetItemUseCase getItem;

    public ItemController(CreateItemUseCase createItem, GetItemUseCase getItem) {
        this.createItem = createItem;
        this.getItem = getItem;
    }

    @PostMapping
    public ResponseEntity<ItemResponse> create(@RequestBody @Valid CreateItemRequest req) {
        Item item = createItem.create(req.name());
        return ResponseEntity
                .created(URI.create("/items/" + item.id()))
                .body(new ItemResponse(item.id(), item.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> get(@PathVariable UUID id) {
        Item item = getItem.getById(id).orElseThrow(() -> new ItemNotFoundException(id));
        return ResponseEntity.ok(new ItemResponse(item.id(), item.name()));
    }
}
