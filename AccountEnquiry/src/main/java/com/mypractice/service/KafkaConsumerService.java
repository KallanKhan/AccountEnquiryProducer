package com.mypractice.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mypractice.entity.TransactionDetails;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "account_details", groupId = "acc_group_id")
    public void listen(List<TransactionDetails> transactionDetails) {
        System.out.println("Received JSON Messages: " + transactionDetails);
        // Process the received messages as needed
    }
}
