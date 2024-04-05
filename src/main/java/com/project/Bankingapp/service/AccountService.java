package com.project.Bankingapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Bankingapp.DTO.AccountDTO;
import com.project.Bankingapp.mapper.AccountMapper;
import com.project.Bankingapp.model.Account;
import com.project.Bankingapp.repository.AccountRepository;
import com.project.Bankingapp.serviceinterface.AccountServiceInterface;

@Service
public class AccountService implements AccountServiceInterface{
	
	@Autowired
	private AccountRepository accountRepository;
	
	
//
//	public AccountService(AccountRepository accountRepository) {
//		super();
//		this.accountRepository = accountRepository;
//	}



	@Override
	public AccountDTO createAcc(AccountDTO accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}


	@Override
	public AccountDTO getAccountById(Long id) {
		Account account = accountRepository
							.findById(id)
							.orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
		
		return AccountMapper.mapToAccountDTO(account);
	}


	@Override
	public AccountDTO deposit(Long id, double amount) { //deposit amount in account
		//given id exist or not
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
		
		 double total = account.getBalance() + amount;
		 account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}


	@Override
	public AccountDTO withdraw(Long id, double amount) {
		//given id exist or not
		Account account = accountRepository
						.findById(id)
						.orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
				
				//if withdrawal amount is more than balance
				if(account.getBalance()< amount) {
					throw new RuntimeException("Insufficient Balance");
				}
				 double total = account.getBalance() - amount;
				 account.setBalance(total);
				Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}


	@Override
	public List<AccountDTO> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDTO(account))
				.collect(Collectors.toList());
		
	}


	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
		accountRepository.deleteById(id);
		
	}


	
	

}
