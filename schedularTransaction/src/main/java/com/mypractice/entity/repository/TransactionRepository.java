package com.mypractice.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.entity.Transactiondetails;



@Repository
public interface TransactionRepository extends JpaRepository<Transactiondetails, Long>{
	
	@Query("SELECT t FROM  Transactiondetails t WHERE t.status = 'GR'")
	 List<Transactiondetails> findByStatus();
	
}
