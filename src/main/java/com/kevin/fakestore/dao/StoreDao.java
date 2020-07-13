package com.kevin.fakestore.dao;

import com.kevin.fakestore.model.Customer;
import com.kevin.fakestore.model.Item;
import com.kevin.fakestore.model.Sale;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoreDao {

    int insertCustomer(Customer customer);
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(int id);
    int updateCustomerById(int id, Customer customer);

    int insertItem(Item item);
    List<Item> selectAllItems();
    Item getItemBySn(UUID sN);
    Optional<Item> selectItemById(UUID id);
    int deleteItemById(UUID id);
    int updateItemById(UUID id, Item item);

    int insertSale(Sale sale);
    List<Sale> selectAllSales();
    Sale getSaleById(int id);
    Optional<Sale> selectSaleById(int id);
    int deleteSaleById(int id);
    int insertRefundById(Sale sale);
    int updateSaleById(int id, Sale sale);

    int updateStatSale(int id, double cost, int option);
}
