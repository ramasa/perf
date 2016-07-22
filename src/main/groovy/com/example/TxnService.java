package com.example;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TxnService {

	@Autowired
	JdbcTemplate db;

	@Transactional
	public void jdbc(Long a1, Long a2) {

		// no much diff removing 'for update' may be because of no contention		
		Double d = db.queryForObject("select balance from account where id=? for update", Double.class, a1);
		db.queryForObject("select balance from account where id=? for update", Double.class, a2);
		
		int u1=db.update("update account set balance=balance-?  where id=?", 10, a1);
		int u2=db.update("update account set balance=balance+?  where id=?", 10, a2);
		
		if(u1 !=1 || u2!=1)
			throw new RuntimeException();
		
	}
}
