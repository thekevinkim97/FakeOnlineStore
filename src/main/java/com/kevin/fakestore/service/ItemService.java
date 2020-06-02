package com.kevin.fakestore.service;

import com.kevin.fakestore.dao.StoreDao;
import com.kevin.fakestore.model.Item;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ItemService {

    private final StoreDao storeDao;

    public ItemService(@Qualifier("postgres") StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public int addItem(Item item) {
        return storeDao.insertItem(item);
    }

    public List<Item> getAllItems() {
        return storeDao.selectAllItems();
    }

    public Optional<Item> getItemById(UUID id) {
        return storeDao.selectItemById(id);
    }

    public int deleteItem(UUID id) {
        return storeDao.deleteItemById(id);
    }

    public int updateItem(UUID id, Item newItem) {
        return storeDao.updateItemById(id, newItem);
    }
}
