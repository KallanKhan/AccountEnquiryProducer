package com.mypractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.entity.Transactiondetails;
import com.mypractice.entity.repository.TransactionRepository;

@Service
public class transactionServiceImp implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public transactionServiceImp(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public List<Transactiondetails> fetchData() {
		System.out.println("transactionServiceImp.fetchData()");
		String str = "GR";
		List<Transactiondetails> transactionDetails = transactionRepository.findByStatus();
		System.out.println("transactionDetail====" + transactionDetails);

		String topic = "account_details"; // Replace with your Kafka topic
        System.out.println();
		// List<TransactionDetails> transactionDetails =
		// transactionRepository.findByStatus("your-status");

		String jsonTransactionDetails = convertListToJson(transactionDetails);

		kafkaTemplate.send(topic, jsonTransactionDetails);
		System.out.println("TransactionDetails sent: " + jsonTransactionDetails);

		return transactionDetails;
	}

	private String convertListToJson(List<Transactiondetails> transactionDetails) {
		// Use your preferred JSON library (e.g., Jackson) to convert the list to JSON
		// string
		// Example using Jackson:
		ObjectMapper objectMapper = new ObjectMapper();
		String transactionDetail = null;
		try {
			transactionDetail = objectMapper.writeValueAsString(transactionDetails);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// For simplicity, a basic example using Java's toString method
		return transactionDetail;
	}
}
