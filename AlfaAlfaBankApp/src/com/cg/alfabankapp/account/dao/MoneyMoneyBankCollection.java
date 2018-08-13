//This class extends the BankAccountCollection .
//It also defines various methods specific to the Money money bank.
package com.cg.alfabankapp.account.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cg.bank.framework.account.dao.BankAccountCollection;
import com.cg.bank.framework.account.pojo.BankAccount;
import com.cg.bank.framework.account.pojo.Customer;

public class MoneyMoneyBankCollection extends BankAccountCollection {

	// This method removes the bank bank account from the Database.
	public void removeBankAccountByAccountNumber(int accountNumberToBeRemoved) {
		for (BankAccount bankAccount : BankAccountCollection.viewAll()) {
			if (bankAccount.getAccountNumber() == accountNumberToBeRemoved) {
				BankAccountCollection.viewAll().remove(bankAccount);
				break;
			}
		}
	}

	// It fetches the account by the account number.
	public BankAccount getAccountByAccountNumber(int accountToBeSearched) {
		System.out.println("Account number in bank Account  : "+accountToBeSearched);
		System.out.println();
		System.out.println(BankAccountCollection.viewAll());
		for (BankAccount bankAccount : BankAccountCollection.viewAll()) {
			if (bankAccount.getAccountNumber() == accountToBeSearched) {
				return bankAccount;
			}
		}
		return null;
	}

	// it fetches the customer list associated with the MMBank
	public Collection<Customer> getCustomers() {
		List<Customer> listOfCustomer = new ArrayList<Customer>();
		for (BankAccount s : viewAll()) {
			listOfCustomer.add(s.getAccountHolder());
		}
		return listOfCustomer;
	}

	// It uses the withdraw() method of the BankAccount and performs the withdrawal
	// action on a given account.
	public Double withdrawAmount(int accountToDeductedFrom, double amount) {
		for (BankAccount b : viewAll()) {

			if ((b.getAccountNumber() == accountToDeductedFrom)) {
				b.withdraw(amount);
				return amount;
			}
		}
		return 0.0;	
	}

	// It uses the deposit() method of the BankAccount and performs the deposit
	// action on a given account.
	public Double depositAmount(int accountToBeDepositedIn, double amount) {
		for (BankAccount b : viewAll()) {
			if ((b.getAccountNumber() == accountToBeDepositedIn)) {
				b.deposit(amount);
				return amount;
			}
		}
		return 0.0;
	}

	public Double performFundTransfer(int receipientAccountNumber, int donerAccountNumber, double amountToBeTransffered) {
		
		for(BankAccount receiver : viewAll() ) {
			if(receiver.getAccountNumber() == receipientAccountNumber) {
				for(BankAccount sender : viewAll() ) {
					if(sender.getAccountNumber() == donerAccountNumber) {
						receiver.deposit(sender.withdraw(amountToBeTransffered));
						return amountToBeTransffered;
					}
				}
			}
		}
		return 0.0;
	}

	public List<BankAccount> getBankAccounts() {
		
		List<BankAccount> listOfAccounts = new ArrayList<BankAccount>();
		for (BankAccount s : viewAll()) {
			listOfAccounts.add(s);
		}
		return listOfAccounts;
	}

}
