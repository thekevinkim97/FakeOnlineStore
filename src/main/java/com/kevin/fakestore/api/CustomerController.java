package com.kevin.fakestore.api;

import com.kevin.fakestore.model.Customer;
import com.kevin.fakestore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addCustomer(@Valid @NonNull @RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping(path = "/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        return customerService.getCustomerById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateCustomer(@PathVariable("id") int id, @Valid @NonNull @RequestBody Customer customerToUpdate) {
        customerService.updateCustomer(id, customerToUpdate);
    }
}
