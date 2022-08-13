package com.malsack.company.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("company")
public class CompanyModel {
	@Id
	private String id;
	@Field(name = "code")
	@Indexed(unique = true)
	private String companyCode;
	@Field(name = "name")
	@Indexed(unique = true)
	private String companyName;
	@Field(name = "ceo")
	private String companyCEO;
	@Field(name = "turnover")
	private Double companyTurnover;
	@Field(name = "website")
	private String companyWebsite;
	@Field(name = "exchange")
	private String stockExchange;

	public CompanyModel(Integer id, String companyCode, String companyName, String companyCEO, Double companyTurnover,
			String companyWebsite, String stockExchange) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchange = stockExchange;
	}

	public CompanyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public Double getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(Double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	@Override
	public String toString() {
		return "CompanyModel [companyCode=" + companyCode + ", companyName=" + companyName + ", companyCEO="
				+ companyCEO + ", companyTurnover=" + companyTurnover + ", companyWebsite=" + companyWebsite
				+ ", stockExchange=" + stockExchange + "]";
	}

}
