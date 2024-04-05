package com.project.Bankingapp.mapper;

import com.project.Bankingapp.DTO.AccountDTO;
import com.project.Bankingapp.model.Account;

//converting accountdto to account jpa and the storing in database
public class AccountMapper {
	
	//converting accountdto to account jpa
	public static Account mapToAccount(AccountDTO accountDTO) {
		Account account = new Account(
				accountDTO.getId(),
				accountDTO.getAccHolderName(),
				accountDTO.getBalance()
				);
		return account;
	}

	
	//converting jpa to account accountdto
	public static AccountDTO mapToAccountDTO(Account account) {
		AccountDTO accountDTO = new AccountDTO(
				account.getId(),
				account.getAccHolderName(),
				account.getBalance()
				);
		return accountDTO;
		
	}
	
	
}
