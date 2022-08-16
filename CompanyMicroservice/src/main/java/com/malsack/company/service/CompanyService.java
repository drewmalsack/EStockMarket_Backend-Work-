package com.malsack.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malsack.company.model.CompanyModel;
import com.malsack.company.repository.CompanyRepository;

@Service
public class CompanyService {

		private final CompanyRepository companyRepository;
		
		@Autowired
		public CompanyService(CompanyRepository repository) {
			this.companyRepository = repository;
		}
		
		public void addCompany(CompanyModel company) {
			companyRepository.insert(company);
		}
		
		public Optional<CompanyModel> getCompanyInfo(String companyCode) {
			return companyRepository.findByCompanyCode(companyCode);
		}
		
		public List<CompanyModel> getAllCompanyInfo() {
			return companyRepository.findAll();
		}
		
		public void deleteCompany(String companyCode) {
			companyRepository.deleteByCode(companyCode);
		}
}
