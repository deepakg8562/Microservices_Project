package com.deloitte.bankingApplication.services;

import com.deloitte.bankingApplication.entity.Account;
import com.deloitte.bankingApplication.repo.AccountRepository;
import com.deloitte.bankingApplication.repo.TransactionRepository;
import com.deloitte.bankingApplication.utils.CodeGenerator;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	public Account getAccount(String sortCode, String accountNumber) {
		Optional<Account> account = accountRepository.findBySortCodeAndAccountNumber(sortCode, accountNumber);

		account.ifPresent(value -> value
				.setTransactions(transactionRepository.findBySourceAccountIdOrderByInitiationDate(value.getId())));

		return account.orElse(null);
	}

	public Account getAccount(String accountNumber) {
		Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

		return account.orElse(null);
	}

	public Account createAccount(String bankName, String ownerName) {
		CodeGenerator codeGenerator = new CodeGenerator();
		Account newAccount = new Account(bankName, ownerName, codeGenerator.generateSortCode(),
				codeGenerator.generateAccountNumber(), 0.00);
		return accountRepository.save(newAccount);
	}
}
