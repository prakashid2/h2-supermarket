package com.ikonprogrammers.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikonprogrammers.supermarket.domain.Employee;
import com.ikonprogrammers.supermarket.domain.SuperMarket;
import com.ikonprogrammers.supermarket.repositories.EmployeeRepository;
import com.ikonprogrammers.supermarket.repositories.SuperMarketRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	/**
	 * The JPA repository
	 */
	@Autowired
	private EmployeeRepository employeeRepo;
	
	/**
	 * The JPA repository
	 */
	@Autowired
	private SuperMarketRepository marketRepo;
	
	
	/**
	 * Used to fetch all Employee objects from DB
	 * @return list of {@link Employee}
	 */
	@GetMapping(value="/all")
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
	
	/**
	 * Used to find and return Employee by its name
	 * @param name refers to name of the employee
	 * @return {@link Employee} object
	 */
	@GetMapping(value="/{name}")
	public Employee findByName(@PathVariable final String name) {
		return employeeRepo.findByName(name);
	}
	
	/**
	 * Used to create employee in DB
	 * @param employee refers to the employee that needs to be saved
	 * @return {@link Employee} created
	 */
	@PostMapping(value="/load")
	public Employee load(@RequestBody final Employee employee) {
		Long marketId = employee.getMarket().getId();
		SuperMarket market = marketRepo.findOne(marketId);
		employee.setMarket(market);
		employeeRepo.save(employee);
		return employeeRepo.findByName(employee.getName());
	}
	
}
