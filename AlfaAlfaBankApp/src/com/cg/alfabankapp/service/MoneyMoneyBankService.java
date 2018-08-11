package com.cg.alfabankapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cg.alfabankapp.account.dao.MoneyMoneyBankCollection;
import com.cg.bank.framework.account.dao.BankAccountCollection;
import com.cg.bank.framework.account.pojo.BankAccount;
import com.cg.bank.framework.account.pojo.Customer;

public class MoneyMoneyBankService {

	MoneyMoneyBankCollection bankCollection = new MoneyMoneyBankCollection();
	
	public BankAccount addBankAccount(BankAccount bankAccount) {
		bankCollection.addBankAccount(bankAccount);
		return bankAccount;
	}
	
	public void removeBankAccountByAccountNumber(int accountNumberToBeRemoved) {
		bankCollection.removeBankAccountByAccountNumber(accountNumberToBeRemoved);
	}
	
	public BankAccount getAccountByAccountNumber(int accountToBeSearched) {
	  
	  return bankCollection.getAccountByAccountNumber(accountToBeSearched);
	}
	
	public Collection<Customer> getCustomers() {
		return bankCollection.getCustomers();
	}
	
	public void withdrawAmount(int accountToDeductedFrom, double amount) {
		bankCollection.withdrawAmount(accountToDeductedFrom, amount);
	}
	
	public void depositAmount(int accountToBeDepositedIn, double amount) {
		bankCollection.depositAmount(accountToBeDepositedIn, amount);
	}

   public void performFundTransfer(int receipientAccountNumber, int donerAccountNumber, double amountToBeTransffered) {
		
		bankCollection.performFundTransfer(receipientAccountNumber, donerAccountNumber, amountToBeTransffered);
	}
}
