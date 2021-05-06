package com.gcavalli.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcavalli.dsvendas.dto.SaleAmountBySellerDTO;
import com.gcavalli.dsvendas.dto.SaleDTO;
import com.gcavalli.dsvendas.dto.SellerSuccessRateDTO;
import com.gcavalli.dsvendas.repositories.SaleRepository;
import com.gcavalli.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		//findAll abaixo busca todos os sellers do bd e coloca-os em memória e depois no cache. Solução show para o nosso
		//caso de termos poucos vendedores e querermos reduzir a qtde de selects ao buscar sales (estava fazendo 1 select pra cada vendedor)
		sellerRepository.findAll();
		return repo.findAll(pageable).map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleAmountBySellerDTO> amountGroupBySeller() {
		return repo.amountGroupBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SellerSuccessRateDTO> successRateGroupBySeller() {
		return repo.successRateGroupBySeller();
	}
	
}
