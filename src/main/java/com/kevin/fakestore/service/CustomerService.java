package com.kevin.fakestore.service;

import com.kevin.fakestore.dao.StoreDao;
import com.kevin.fakestore.model.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final StoreDao storeDao;

    public CustomerService(@Qualifier("postgres") StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public int addCustomer(Customer customer) {
        return storeDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return storeDao.selectAllCustomers();
    }

    public Optional<Customer> getCustomerById(int id) {
        return storeDao.selectCustomerById(id);
    }

    public int updateCustomer(int id, Customer newCustomer) {
        return storeDao.updateCustomerById(id, newCustomer);
    }
}
