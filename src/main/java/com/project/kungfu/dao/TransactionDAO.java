
package com.project.kungfu.dao;

import java.util.List;

import com.project.kungfu.model.Transaction;

public interface TransactionDAO {

	public void addTransaction(Transaction transaction);

	public List<Transaction> getAllTransactions(String specs, String orderBy);

	public void deleteTransaction(Integer transactionId);

	public Transaction updateTransaction(Transaction transaction);

	public Transaction getTransaction(int transactionid);
}
