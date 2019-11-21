package com.ikonprogrammers.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikonprogrammers.supermarket.domain.SuperMarket;

public interface SuperMarketRepository extends JpaRepository<SuperMarket, Long> {
	SuperMarket findByName(String name);	
}
