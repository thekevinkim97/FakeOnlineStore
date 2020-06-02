package com.kevin.fakestore.dao;

import com.kevin.fakestore.model.Customer;
import com.kevin.fakestore.model.Item;
import com.kevin.fakestore.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class StoreDataAccessService implements StoreDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StoreDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Customers
    @Override
    public int insertCustomer(Customer customer) {
        return 0;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> selectCustomerById(int id) {
        return Optional.empty();
    }

    @Override
    public int deleteCustomerById(int id) {
        return 0;
    }

    @Override
    public int updateCustomerById(int id, Customer customer) {
        return 0;
    }


    //Items
    @Override
    public int insertItem(Item item) {
        return 0;
    }

    @Override
    public List<Item> selectAllItems() {
        return null;
    }

    @Override
    public Optional<Item> selectItemById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteItemById(UUID id) {
        return 0;
    }

    @Override
    public int updateItemById(UUID id, Item item) {
        return 0;
    }


    //Sales
    @Override
    public int insertSale(Sale sale) {
        return 0;
    }

    @Override
    public List<Sale> selectAllSales() {
        return null;
    }

    @Override
    public Optional<Sale> selectSaleById(int id) {
        return Optional.empty();
    }

    @Override
    public int deleteSaleById(int id) {
        return 0;
    }

    @Override
    public int updateSaleById(int id, Sale sale) {
        return 0;
    }
}
