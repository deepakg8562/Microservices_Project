package com.deloitte.bankingApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.bankingApplication.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	// TODO Limit to recent transactions and implement separate endpoint to view old
	// transactions
	List<Transaction> findBySourceAccountIdOrderByInitiationDate(long id);
}
