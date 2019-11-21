package com.ikonprogrammers.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikonprogrammers.supermarket.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByName(String name);
}
