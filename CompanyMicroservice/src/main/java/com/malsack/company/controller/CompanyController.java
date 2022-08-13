package com.malsack.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malsack.company.model.CompanyModel;
import com.malsack.company.service.CompanyService;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyController {
	
	private final CompanyService companyService;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<CompanyModel> addCompany(@RequestBody CompanyModel company) {
		companyService.addCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/info/{companyCode}")
	public ResponseEntity<CompanyModel> getCompanyInfo(@PathVariable String companyCode) {
		return ResponseEntity.ok(companyService.getCompanyInfo(companyCode));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<CompanyModel>> getAllCompanyInfo() {
		return ResponseEntity.ok(companyService.getAllCompanyInfo());
	}
	
	@DeleteMapping("/delete/{companyCode}")
	public ResponseEntity deleteCompany(@PathVariable String companyCode) {
		companyService.deleteCompany(companyCode);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
