package com.malsack.stock.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger=LoggerFactory.getLogger(StockController.class);
	
	@PostMapping("/add/{companyCode}")
	public StockModel addStock(@RequestBody StockModel stockModel, @PathVariable String companyCode) {
		return stockService.add(stockModel, companyCode.toUpperCase());
	}
	
	@GetMapping("/get/{companyCode}/{start}/{end}")
	public List<StockModel> getAllStocksByCompanyCode(@PathVariable String companyCode, @PathVariable String start, @PathVariable String end){
		List<StockModel> list = stockService.findAllByCompanyCode(companyCode.toUpperCase(), start, end);
		if(list.isEmpty()) {
			logger.info("no stock prices found between times: {} and: {}", start, end);
		}else {
			logger.info("stock prices found: {}:{}", list.size(), list);
		}
		
		return list;
		
	}
	
	@GetMapping("/getlatest/{companyCode}")
	public StockModel getLatestByCompanyCode(@PathVariable String companyCode) {
		return stockService.findLatestPriceByCode(companyCode.toUpperCase());
	}
	
	@DeleteMapping("delete/{companyCode}")
	@Transactional
	public void deleteAllByCompanyCode(@PathVariable String companyCode) {
		stockService.deleteAllByCompanyCode(companyCode.toUpperCase());
	}
}
