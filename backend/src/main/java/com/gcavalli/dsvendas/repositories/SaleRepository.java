package com.gcavalli.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcavalli.dsvendas.dto.SaleAmountBySellerDTO;
import com.gcavalli.dsvendas.dto.SellerSuccessRateDTO;
import com.gcavalli.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.gcavalli.dsvendas.dto.SaleAmountBySellerDTO(obj.seller, SUM(obj.amount)) FROM Sale obj GROUP BY obj.seller")
	public List<SaleAmountBySellerDTO> amountGroupBySeller();
	
	@Query("SELECT new com.gcavalli.dsvendas.dto.SellerSuccessRateDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) FROM Sale obj GROUP BY obj.seller")
	public List<SellerSuccessRateDTO> successRateGroupBySeller();
}
