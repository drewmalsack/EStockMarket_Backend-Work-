package com.malsack.stock.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malsack.stock.model.StockModel;
import com.malsack.stock.repository.StockRepository;

@Service
public class StockService {

	private final StockRepository stockRepository;
	
	@Autowired
	public StockService(StockRepository stockRepository) {
		this.stockRepository=stockRepository;
	}
	
	public StockModel add(StockModel stockModel, String companyCode) {
		StockModel stock = stockModel;
		stock.setPriceTimestamp(new Timestamp(new Date().getTime()));
		stock.setCompanyCode(companyCode);
		return stockRepository.save(stock);
	}
	
	public List<StockModel> findAllByCompanyCode(String companyCode, String start, String end) {
		
		return stockRepository.findAll().stream()
				.filter(x -> x.getCompanyCode().equals(companyCode) && !(x.getPriceTimestamp().before(Timestamp.from(Instant.parse(start))) || x.getPriceTimestamp()
						.after(Timestamp.from(Instant.parse(end))))).collect(Collectors.toList());
	}
	
	public void deleteAllByCompanyCode(String companyCode) {
		stockRepository.deleteByCompanyCode(companyCode);
	}
}
