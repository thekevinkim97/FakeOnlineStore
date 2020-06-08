package com.kevin.fakestore.service;

import com.kevin.fakestore.dao.StoreDao;
import com.kevin.fakestore.model.Sale;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final StoreDao storeDao;

    public SaleService(@Qualifier("postgres") StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public int addSale(Sale sale) {
        return storeDao.insertSale(sale);
    }

    public List<Sale> getAllSales() {
        return storeDao.selectAllSales();
    }

    public Optional<Sale> getSaleById(int id) {
        return storeDao.selectSaleById(id);
    }

    public int deleteSale(int id) {
        return storeDao.deleteSaleById(id);
    }

    public int updateSale(int id, Sale sale) {
        return storeDao.updateSaleById(id, sale);
    }
}
