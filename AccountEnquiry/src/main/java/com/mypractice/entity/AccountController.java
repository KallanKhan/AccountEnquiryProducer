package com.mypractice.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@PostMapping("/tranDetails")
	public ResponseEntity<TransactionDetails> saveData(@RequestBody TransactionDetails transactionDetails) {
		System.out.println("transactionDetails=="+transactionDetails);
		TransactionDetails transactionDetail=	accountRepository.save(transactionDetails);
		return new ResponseEntity<>(transactionDetail, HttpStatus.CREATED);
		
	}

}
