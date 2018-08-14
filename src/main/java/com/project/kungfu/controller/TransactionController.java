package com.project.kungfu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.kungfu.model.Product;
import com.project.kungfu.model.Student;
import com.project.kungfu.model.Transaction;
import com.project.kungfu.service.ProductService;
import com.project.kungfu.service.StudentService;
import com.project.kungfu.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/TransactionCreation")
	public ModelAndView transctionCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Transaction transaction = new Transaction();
		List<Product> productList = productService.getAllProducts("", " PROD_ID desc ");
		List<Student> studentList = studentService.getAllStudents("", " STUD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("transaction", transaction);
		model.addObject("productList", productList);
		model.addObject("studentList", studentList);
		model.setViewName("transactionForm");
		return model;
	}

	@RequestMapping(value = "/TransactionCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("transaction") Transaction transaction, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Student Controller");
		}
		
		transactionService.addTransaction(transaction);
		model.setViewName("redirect:/TransactionList");
		return model;
	}

	@RequestMapping(value = "/TransactionList")
	public ModelAndView transctionList(ModelAndView model, HttpServletRequest request) throws IOException {

		
		List<Transaction> transactionList = transactionService.getAllTransactions("", " TRN_ID desc ");
		for(Transaction transaction: transactionList)
		{
			transaction.setStudent(studentService.getStudent(transaction.getSTUD_ID()));
			transaction.setProduct(productService.getProduct(transaction.getPROD_ID()));
		}
		String sid = request.getSession().getId();
		model.addObject("transactionList", transactionList);
		model.setViewName("transactionList");
		return model;
	}

	@RequestMapping(value = "/TransactionEdit")
	public ModelAndView editTransction(ModelAndView model, HttpServletRequest request) throws IOException {

		int transactionid = Integer.parseInt(request.getParameter("id"));
		Transaction transaction =transactionService.getTransaction(transactionid);
		List<Product> productList = productService.getAllProducts("", " PROD_ID desc ");
		List<Student> studentList = studentService.getAllStudents("", " STUD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("transaction", transaction);
		model.addObject("productList", productList);
		model.addObject("studentList", studentList);
		model.setViewName("transactionForm");
		return model;
	}

	@RequestMapping(value = "/TransactionDelete")
	public ModelAndView deleteTransction(ModelAndView model, HttpServletRequest request) throws IOException {

		int transactionId = Integer.parseInt(request.getParameter("id"));
		transactionService.deleteTransaction(transactionId);
		model.setViewName("redirect:/TransactionList");
		return model;
	}

}
