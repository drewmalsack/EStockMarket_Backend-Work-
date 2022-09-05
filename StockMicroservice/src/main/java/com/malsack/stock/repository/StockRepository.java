package com.malsack.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.malsack.stock.model.StockModel;

@Repository
public interface StockRepository extends JpaRepository<StockModel, Integer>{
	
	//@Query("delete from stocks s where s.code = :companyCode")
	List<StockModel> deleteByCompanyCode(String companyCode);
	
	@Query("SELECT s FROM StockModel s WHERE s.companyCode=?1 order by s.priceTimestamp desc")
	List<StockModel> findLatestStockPriceByCode(String companyCode);
}
