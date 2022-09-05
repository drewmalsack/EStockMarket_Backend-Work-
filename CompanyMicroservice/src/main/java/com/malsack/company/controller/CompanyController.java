package com.malsack.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

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
	
	Logger logger=LoggerFactory.getLogger(CompanyController.class);
	
	@PostMapping("/register")
	public ResponseEntity<CompanyModel> addCompany(@RequestBody CompanyModel company) {
		company.setCompanyCode(company.getCompanyCode().toUpperCase());
		companyService.addCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/info/{companyCode}")
	public ResponseEntity<CompanyModel> getCompanyInfo(@PathVariable String companyCode) {
		if(companyService.getCompanyInfo(companyCode.toUpperCase()).isPresent()) {
			return ResponseEntity.ok(companyService.getCompanyInfo(companyCode.toUpperCase()).get());
		} else {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "No company found with that code"
					);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<CompanyModel>> getAllCompanyInfo() {
		return ResponseEntity.ok(companyService.getAllCompanyInfo());
	}
	
	@DeleteMapping("/delete/{companyCode}")
	public ResponseEntity<Void> deleteCompany(@PathVariable String companyCode) {
		companyService.deleteCompany(companyCode.toUpperCase());
		String uri = "http://localhost:8090/api/v1.0/market/stock/delete/{code}";
		Map < String, String > params = new HashMap <> ();
        params.put("code", companyCode);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, params);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
