package com.malsack.stock.controller;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malsack.stock.model.StockModel;
import com.malsack.stock.service.StockService;

@RestController
@RequestMapping("/api/v1.0/market/stock")
public class StockController {

	private final StockService stockService;
	
	@Autowired
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
	@PostMapping("/add/{companyCode}")
	public StockModel addStock(@RequestBody StockModel stockModel, @PathVariable String companyCode) {
		return stockService.add(stockModel, companyCode);
	}
	
	@GetMapping("/get/{companyCode}/{start}/{end}")
	public List<StockModel> getAllStocksByCompanyCode(@PathVariable String companyCode, @PathVariable String start, @PathVariable String end){
		return stockService.findAllByCompanyCode(companyCode, start, end);
		
	}
	
	@DeleteMapping("delete/{companyCode}")
	@Transactional
	public void deleteAllByCompanyCode(@PathVariable String companyCode) {
		stockService.deleteAllByCompanyCode(companyCode);
	}
}
