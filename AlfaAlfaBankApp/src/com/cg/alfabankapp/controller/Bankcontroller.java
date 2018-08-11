package com.cg.alfabankapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.alfabankapp.factory.MMBankFactory;
import com.cg.alfabankapp.service.MoneyMoneyBankService;

@WebServlet("*.app")
public class Bankcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Object> account = new HashMap<String, Object>();
		MMBankFactory mmBankFactory = new MMBankFactory();

		MoneyMoneyBankService serviceLayer = new MoneyMoneyBankService();

		String name = request.getServletPath();
		System.out.println(name);

		switch (name) {
		case "/addNewAccount.app":
			account.put("accountHolderName", request.getParameter("customerName"));
			account.put("gender", request.getParameter("gender"));

			String dob = request.getParameter("dob");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dob, formatter);

			account.put("dateOfBirth", date);
			account.put("contactNumber", request.getParameter("contact_no"));
			account.put("houseNo", request.getParameter("houseNo"));
			account.put("street", request.getParameter("street"));
			account.put("city", request.getParameter("city"));
			account.put("state", request.getParameter("state"));
			account.put("pincode", request.getParameter("pincode"));
			account.put("email", request.getParameter("email"));
			account.put("nationality", request.getParameter("nationality"));

			account.put("accountType", request.getParameter("accountType"));
			System.out.println("&************************&");

			if (request.getParameter("accountType").equals("savingAccount")) {
				if (request.getParameter("salaried").equals("salaried")) {
					account.put("salaried", true);
					account.put("accountBalance", request.getParameter("savSbalance"));
				} else {
					account.put("salaried", false);
					account.put("accountBalance", request.getParameter("savNbalance"));
				}
				System.out.println(mmBankFactory.createNewSavingsAccount(account));
				serviceLayer.addBankAccount(mmBankFactory.createNewSavingsAccount(account));
				
			    HttpSession session = request.getSession();
			    session.setAttribute("createdbankAccount", mmBankFactory.createNewSavingsAccount(account));
			    response.sendRedirect("addNewSuccess.jsp");
		
			} else {
				account.put("odLimit", request.getParameter("overDraft"));
				
				account.put("accountBalance", request.getParameter("curbalance"));
				
				System.out.println(mmBankFactory.createNewCurrentAccount(account));
				
				serviceLayer.addBankAccount(mmBankFactory.createNewCurrentAccount(account));
				
				HttpSession session = request.getSession();
				session.setAttribute("createdbankAccount", mmBankFactory.createNewCurrentAccount(account));
			    response.sendRedirect("addNewSuccess.jsp");
			}
		
			break;

		case "/removenew.app":
//			servicelayer.removeBookFromCart(Integer.parseInt(request.getParameter("bookId")));
//			counter = servicelayer.getCounter();
//			System.out.println(counter);
//			price = servicelayer.getPrice();
//			System.out.println(price);
//			HttpSession session = request.getSession();
//			session.setAttribute("booksInCart", servicelayer.ViewCart());
//			session.setAttribute("counter", servicelayer.getCounter());
//			session.setAttribute("price", servicelayer.getPrice());
//			response.sendRedirect("Cart.jsp");

			break;

		case "/viewAccount.app":

			System.out.println("*********************1");
			
			String accountToSearched = request.getParameter("typedAccount");
			int accountToSearched2 = Integer.parseInt(accountToSearched);
			System.out.println("Account number : "+ accountToSearched2);
			System.out.println(serviceLayer.getAccountByAccountNumber(accountToSearched2));
			
			System.out.println("*********************2");
		    HttpSession session = request.getSession();
		    session.setAttribute("createdbankAccount", serviceLayer.getAccountByAccountNumber(accountToSearched2));
		    
		    System.out.println("*********************3");
			response.sendRedirect("viewAccount.jsp");

			break;
			
//		case "/showBook.app":

//			session = request.getSession();
//			session.setAttribute("availableBooks", servicelayer.ViewBook());
//			response.sendRedirect("home.jsp");
//
//		case "/dropdownchange.app":
//
//			String AccountType = request.getParameter("accountType");
//			System.out.println(AccountType);
//			session = request.getSession();
//			session.setAttribute("accountType", AccountType);
//			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}