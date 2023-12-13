package com.mypractice.scheduler;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mypractice.entity.Transactiondetails;
import com.mypractice.service.TransactionService;

@Component

public class TransactionScheduler {
	
	 @Autowired
	 private TransactionService tranService;
	 @Autowired
	 private Executor taskExecutor;
	 private final ExecutorService executorService = Executors.newSingleThreadExecutor();
	    // Run every 5 seconds
	 @Scheduled(fixedRate = 300000) // Run every 5 minutes
	    public void fetchDataFromDatabase() {
	        taskExecutor.execute(() -> {
	            List<Transactiondetails> data = tranService.fetchData();
	            // Process the fetched data
	            System.out.println("Fetched data from the database: " + data);
	        });
	    }
}
