package com.kevin.fakestore.dao;

import com.kevin.fakestore.model.Customer;
import com.kevin.fakestore.model.Item;
import com.kevin.fakestore.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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
        final String sql = "INSERT INTO customer (name, email) VALUES (?,?)";
        return jdbcTemplate.update(
                sql,
                customer.getName(),
                customer.getEmail()
        );
    }

    @Override
    public List<Customer> selectAllCustomers() {
        final String sql = "SELECT id, name, email FROM customer";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int idC = Integer.parseInt(resultSet.getString ("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            return new Customer(idC, name, email);
        });
    }

    @Override
    public Optional<Customer> selectCustomerById(int id) {
        final String sql = "SELECT id, name, email FROM customer WHERE id = ?";
        Customer customer = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int idC = Integer.parseInt(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    return new Customer(idC, name, email);
                }
        );
        return Optional.ofNullable(customer);
    }

    @Override
    public int deleteCustomerById(int id) {
        final String sql = "DELETE FROM customer WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateCustomerById(int id, Customer customer) {
        final String sql = "UPDATE FROM customer WHERE id = ?";
        return jdbcTemplate.update(sql, id, customer);
    }


    //Items
    @Override
    public int insertItem(Item item) {
        final String sql = "INSERT INTO item (serial_number, category_id, name, price, description, store_quantity, online_quantity) VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(
                sql,
                item.getSerialNumber(),
                item.getCategoryId(),
                item.getName(),
                item.getPrice(),
                item.getDescription(),
                item.getStoreQuantity(),
                item.getOnlineQuantity()
        );
    }

    @Override
    public List<Item> selectAllItems() {
        final String sql = "SELECT serial_number, category_id, name, price, description, store_quantity, online_quantity FROM item";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID serial_number = UUID.fromString(resultSet.getString("serial_number"));
            int category_id = Integer.parseInt(resultSet.getString("category_id"));
            String name = resultSet.getString("name");
            Double price = Double.parseDouble(resultSet.getString("price"));
            String desc = resultSet.getString("description");
            int store_quantity = Integer.parseInt(resultSet.getString("store_quantity"));
            int online_quantity = Integer.parseInt(resultSet.getString("online_quantity"));
            return new Item(serial_number, category_id, name, price, desc, store_quantity, online_quantity);
        });
    }

    @Override
    public Optional<Item> selectItemById(UUID id) {
        final String sql = "SELECT serial_number, category_id, name, price, description, store_quantity, online_quantity FROM item WHERE id = ?";
        Item item = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID sN = UUID.fromString(resultSet.getString("serial_number"));
                    int category_id = Integer.parseInt(resultSet.getString("category_id"));
                    String name = resultSet.getString("name");
                    Double price = Double.parseDouble(resultSet.getString("price"));
                    String desc = resultSet.getString("description");
                    int store_quantity = Integer.parseInt(resultSet.getString("store_quantity"));
                    int online_quantity = Integer.parseInt(resultSet.getString("online_quantity"));
                    return new Item(sN, category_id, name, price, desc, store_quantity, online_quantity);
                }
        );
        return Optional.ofNullable(item);
    }

    @Override
    public int deleteItemById(UUID id) {
        final String sql = "DELETE FROM item WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateItemById(UUID id, Item item) {
        final String sql = "UPDATE FROM item WHERE id = ?";
        return jdbcTemplate.update(sql, id, item);
    }


    //Sales
    @Override
    public int insertSale(Sale sale) {
        final String sql = "INSERT INTO sale (customer_id, item_serial_number, shipping_address)";
        return jdbcTemplate.update(
                sql,
                sale.getCustomer_id(),
                sale.getItem_serial_number(),
                sale.getShipping_address()
        );
    }

    @Override
    public List<Sale> selectAllSales() {
        final String sql = "SELECT id, customer_id, item_serial_number, shipping_address, sale_date FROM sale";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = Integer.parseInt(resultSet.getString("id"));
            int customer_id = Integer.parseInt(resultSet.getString("customer_id"));
            UUID item_serial_number = UUID.fromString(resultSet.getString("item_serial_number"));
            String shipping_address = resultSet.getString("shipping_address");
            Date sale_date = Date.valueOf(resultSet.getString("sale_date"));
            return new Sale(id, customer_id, item_serial_number, shipping_address, sale_date);
        });
    }

    @Override
    public Optional<Sale> selectSaleById(int id) {
        final String sql = "SELECT id, customer_id, item_serial_number, shipping_address, sale_date FROM sale WHERE id = ?";
        Sale sale = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int idS = Integer.parseInt(resultSet.getString("id"));
                    int customer_id = Integer.parseInt(resultSet.getString("customer_id"));
                    UUID item_serial_number = UUID.fromString(resultSet.getString("item_serial_number"));
                    String shipping_address = resultSet.getString("shipping_address");
                    Date sale_date = Date.valueOf(resultSet.getString("sale_date"));
                    return new Sale(idS, customer_id, item_serial_number, shipping_address, sale_date);
                }
        );
        return Optional.ofNullable(sale);
    }

    @Override
    public int deleteSaleById(int id) {
        final String sql = "DELETE FROM sale WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateSaleById(int id, Sale sale) {
        final String sql = "UPDATE FROM sale WHERE id = ?";
        return jdbcTemplate.update(sql, id, sale);
    }
}
