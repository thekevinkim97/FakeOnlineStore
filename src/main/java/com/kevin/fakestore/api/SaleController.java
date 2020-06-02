package com.kevin.fakestore.api;

import com.kevin.fakestore.model.Sale;
import com.kevin.fakestore.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/sales")
@RestController
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public void addSale(@Valid @NonNull @RequestBody Sale sale) {
        saleService.addSale(sale);
    }

    @GetMapping(path = "/all")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping(path = "{id}")
    public Sale getSaleById(@PathVariable("id") int id) {
        return saleService.getSaleById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSaleById(@PathVariable("id") int id) {
        saleService.deleteSale(id);
    }

    @PutMapping(path = "{id}")
    public void updateSaleById(@PathVariable("id") int id, @Valid @NonNull @RequestBody Sale sale) {
        saleService.updateSale(id, sale);
    }
}
