package com.mypractice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Transactiondetails")
public class TransactionDetails {
	
	 //private String transactionId;
	  //  private String description;

@Id
@Column(name="transactionId")
private long transactionid;
@Column(name="acountNumber")
private String acountnumber;
@Column(name="bankCode")
private String bankcode; 
@Column(name="name")
private String name;
@Column(name="recName")
private String recname; 
@Column(name="sentName")
private String sentname; 
@Column(name="status")
private String status;
@Column(name="WSResponse")
private String WSResponse;
}