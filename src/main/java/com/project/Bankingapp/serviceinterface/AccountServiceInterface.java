package com.project.Bankingapp.serviceinterface;

import java.util.List;

import com.project.Bankingapp.DTO.AccountDTO;

public interface AccountServiceInterface {
	
	AccountDTO createAcc(AccountDTO accountDto);
	AccountDTO getAccountById(Long id);
	AccountDTO deposit(Long id,double amount);
	AccountDTO withdraw(Long id,double amount);
	List<AccountDTO> getAllAccounts();
	void deleteAccount(Long id);
}
