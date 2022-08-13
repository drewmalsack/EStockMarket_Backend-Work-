package com.malsack.stock.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "stocks")
public class StockModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code")
	private String companyCode;

	@Column(name = "price")
	private Double stockPrice;

	@Column(name = "timestamp")
	private Timestamp priceTimestamp;

	public StockModel(Integer id, String companyCode, Double stockPrice, Timestamp priceTimestamp) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockPrice = stockPrice;
		this.priceTimestamp = priceTimestamp;
	}

	public StockModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Timestamp getPriceTimestamp() {
		return priceTimestamp;
	}

	public void setPriceTimestamp(Timestamp priceTimestamp) {
		this.priceTimestamp = priceTimestamp;
	}

	@Override
	public String toString() {
		return "StockModel [id=" + id + ", companyCode=" + companyCode + ", stockPrice=" + stockPrice
				+ ", priceTimestamp=" + priceTimestamp + "]";
	}

}
