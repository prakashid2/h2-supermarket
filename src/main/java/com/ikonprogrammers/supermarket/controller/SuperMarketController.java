package com.ikonprogrammers.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikonprogrammers.supermarket.domain.SuperMarket;
import com.ikonprogrammers.supermarket.repositories.SuperMarketRepository;

@RestController
@RequestMapping("/api/supermarkets")
public class SuperMarketController {

	/**
	 * The JPA Repository
	 */
	@Autowired
	private SuperMarketRepository marketRepo;

	/**
	 * Used to fetch all markets from DB
	 * @return list of {@link SuperMarket}
	 */
	@GetMapping(value="/all")
	public List<SuperMarket> findAll(){
		return marketRepo.findAll();
	}

	/**
	 * Used to find and return a SuperMarket by name
	 * @param name refers to name of the SuperMarket
	 * @return {@link SuperMarket} object
	 */
	@GetMapping(value="/{name}")
	public SuperMarket findByName(@PathVariable final String name) {
		return marketRepo.findByName(name);
	}

	/**
	 * Used to create a supermarket in DB
	 *
	 * @param market refers to the supermarket needs to be saved
	 * @return {@link SuperMarket} created
	 */
	@PostMapping(value="/load")
	public SuperMarket load(@RequestBody final SuperMarket market) {
		//System.out.println("market.getEmployees():"+market.getEmployees());
		marketRepo.save(market);
		//System.out.println("market saved");
		return marketRepo.findByName(market.getName());
	}


}
