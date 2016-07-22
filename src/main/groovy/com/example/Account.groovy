package com.example;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public class Account {
	
	@Id
	Long id;
	
	BigDecimal balance;
}

interface AccountRepo extends JpaRepository<Account, Long>{
	
}
