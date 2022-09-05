package com.malsack.stock.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
	
	public StockModel findLatestPriceByCode(String companyCode) {
		return stockRepository.findLatestStockPriceByCode(companyCode).get(0);
	}
	
	public List<StockModel> findAllByCompanyCode(String companyCode, String start, String end) {
		String datetimeLocalS = start;
		String datetimeLocalE = end;
		if (StringUtils.countMatches(datetimeLocalS, ":") == 1) {
		    datetimeLocalS += ":00";
		}
		if (StringUtils.countMatches(datetimeLocalE, ":") == 1) {
		    datetimeLocalE += ":00";
		}
		Timestamp valueS = Timestamp.valueOf(datetimeLocalS.replace("T", " "));
		Timestamp valueE = Timestamp.valueOf(datetimeLocalE.replace("T", " "));
		return stockRepository.findAll().stream()
				.filter(x -> x.getCompanyCode().equals(companyCode) && !(x.getPriceTimestamp().before(valueS) || x.getPriceTimestamp()
						.after(valueE))).toList();
	}
	
	public void deleteAllByCompanyCode(String companyCode) {
		stockRepository.deleteByCompanyCode(companyCode);
	}
}
