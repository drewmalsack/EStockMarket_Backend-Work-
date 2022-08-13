package com.malsack.company.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.malsack.company.model.CompanyModel;

public interface CompanyRepository extends MongoRepository<CompanyModel, Integer> {

	@Query("{'code': ?0}")
	Optional<CompanyModel> findByCompanyCode(String companyCode);
	
	@Query(value="{'code': ?0}", delete = true)
	CompanyModel deleteByCode(String companyCode);
}
