package com.malsack.company.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Document("company")
public class CompanyModel {
	@Id
	private String id;
	
	@Field(name = "code")
	@Indexed(unique = true)
	@Size(min=1, max=5)
	@NotNull(message = "Company code must not be empty")
	private String companyCode;
	
	@Field(name = "name")
	@Indexed(unique = true)
	@NotNull(message = "Company name must not be empty")
	private String companyName;
	
	@Field(name = "ceo")
	@NotNull(message = "Company CEO must not be empty")
	private String companyCEO;
	
	@NotNull(message = "Company turnover must not be empty")
	@Field(name = "turnover")
	private Double companyTurnover;
	
	@Field(name = "website")
	@Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$")
	@NotNull(message = "Company website must not be empty")
	private String companyWebsite;
	
	@Field(name = "exchange")
	@NotNull(message = "Stock exchange must not be empty")
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
