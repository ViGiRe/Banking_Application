package com.project.Bankingapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Bankingapp.DTO.AccountDTO;
import com.project.Bankingapp.serviceinterface.AccountServiceInterface;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountServiceInterface accountServiceInterface;

//	public AccountController(AccountServiceInterface accountServiceInterface) {
//		super();
//		this.accountServiceInterface = accountServiceInterface;
//	}
	
	//add account restapi
	@PostMapping
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) { //@RequestBody will map this requestbody to this java object,request body contains JSON so this requsetbody annotation will convert JSON OBJECT into java Object
		
		 AccountDTO addedAccount = accountServiceInterface.createAcc(accountDTO);
		return new ResponseEntity<AccountDTO>(addedAccount, HttpStatus.CREATED);	
	}
	
	// Get account restapi
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
		
		AccountDTO getAccountDTO =accountServiceInterface.getAccountById(id);
		return ResponseEntity.ok(getAccountDTO);	
	}
	
	//Deposit rest api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> Deposit(@PathVariable Long id,
											@RequestBody Map<String, Double> request) {
		
		Double amount = request.get("amount");
		AccountDTO accountDTO = accountServiceInterface.deposit(id, request.get("amount"));
		return ResponseEntity.ok(accountDTO);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraq(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDTO accountDTO = accountServiceInterface.withdraw(id, request.get("amount"));
		return ResponseEntity.ok(accountDTO);	
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAllAccounts(){
		List<AccountDTO> accounts= accountServiceInterface.getAllAccounts();
		return ResponseEntity.ok(accounts);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountServiceInterface.deleteAccount(id);
		return ResponseEntity.ok("Account Deleted Successfully!!");
		
	}
}
