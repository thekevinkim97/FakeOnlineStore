package com.kevin.fakestore.api;

import com.kevin.fakestore.model.CustomerStatistic;
import com.kevin.fakestore.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/CustomerStatistics")
@RestController
public class StatisticController {
    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(path = "/all")
    public List<CustomerStatistic> getAllStats() {
        return statisticService.getAllStats();
    }

    @GetMapping(path = "{id}")
    public CustomerStatistic getStatById(@PathVariable("id") int id) {
        return statisticService.getStatById(id)
                .orElse(null);
    }

}
