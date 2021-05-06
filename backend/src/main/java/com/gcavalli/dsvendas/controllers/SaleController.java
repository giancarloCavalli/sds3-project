package com.gcavalli.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcavalli.dsvendas.dto.SaleAmountBySellerDTO;
import com.gcavalli.dsvendas.dto.SaleDTO;
import com.gcavalli.dsvendas.dto.SellerSuccessRateDTO;
import com.gcavalli.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> page = service.findAll(pageable);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleAmountBySellerDTO>> amountGroupBySeller() {
		List<SaleAmountBySellerDTO> list = service.amountGroupBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-rate-by-seller")
	public ResponseEntity<List<SellerSuccessRateDTO>> successRateGroupBySeller() {
		List<SellerSuccessRateDTO> list = service.successRateGroupBySeller();
		return ResponseEntity.ok(list);
	}
	
}
