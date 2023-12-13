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
public class Transactiondetails {

@Id
@Column(name="transactionid")
private long transactionid;
@Column(name="acountnumber")
private String acountnumber;
@Column(name="bankcode")
private String bankcode; 
@Column(name="name")
private String name;
@Column(name="recname")
private String recname; 
@Column(name="sentname")
private String sentname; 
@Column(name="status")
private String status;
@Column(name="WSResponse")
private String WSResponse;


}
