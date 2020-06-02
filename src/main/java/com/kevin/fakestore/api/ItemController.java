package com.kevin.fakestore.api;

import com.kevin.fakestore.model.Item;
import com.kevin.fakestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/items")
@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public void addItem(@Valid @NonNull @RequestBody Item item) {
        itemService.addItem(item);
    }

    @GetMapping(path = "/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(path = "{id}")
    public Item getItemById(@PathVariable("id") UUID id) {
        return itemService.getItemById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteItemById(@PathVariable("id") UUID id) {
        itemService.deleteItem(id);
    }

    @PutMapping(path = "{id}")
    public void updateItemById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Item itemToUpdate) {
        itemService.updateItem(id, itemToUpdate);
    }
}
