package com.gcavalli.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcavalli.dsvendas.dto.SellerDTO;
import com.gcavalli.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repo;
	
	public List<SellerDTO> findAll() {
		return repo.findAll().stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
	}
	
}
