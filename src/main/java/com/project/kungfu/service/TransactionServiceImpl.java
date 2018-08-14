package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.TransactionDAO;
import com.project.kungfu.model.Attendance;
import com.project.kungfu.model.Transaction;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public void addTransaction(Transaction transaction) {
		transactionDAO.addTransaction(transaction);
		
	}

	@Override
	public List<Transaction> getAllTransactions(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return transactionDAO.getAllTransactions(specs, orderBy);
	}

	@Override
	public void deleteTransaction(Integer transactionId) {
		transactionDAO.deleteTransaction(transactionId);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDAO.updateTransaction(transaction);
	}

	@Override
	public Transaction getTransaction(int transactionid) {
		// TODO Auto-generated method stub
		return transactionDAO.getTransaction(transactionid);
	}

	
	
	
	

}
