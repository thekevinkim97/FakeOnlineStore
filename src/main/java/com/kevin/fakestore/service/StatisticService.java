package com.kevin.fakestore.service;

import com.kevin.fakestore.dao.StoreDao;
import com.kevin.fakestore.model.CustomerStatistic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticService {

    private final StoreDao storeDao;

    public StatisticService(@Qualifier("postgres") StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public List<CustomerStatistic> getAllStats() {
        return storeDao.selectAllStats();
    }

    public Optional<CustomerStatistic> getStatById(int id) {
        return storeDao.selectStatById(id);
    }

}
