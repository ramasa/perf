package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class RunService implements CommandLineRunner {

	@Autowired
	TxnService txnService;

	@Autowired
	Environment env;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Env:" + env.getActiveProfiles()[0]);

		long t1 = new Date().getTime();

		for (int i = 1; i < 1000; i++) {
			Long a1 = (i % 2 == 0) ? 1L : 2L;
			Long a2 = 3 - a1;

			txnService.jdbc(a1, a2);
		}

		System.out.println("Completed in " + (new Date().getTime() - t1) + " milliseconds");
	}

}
