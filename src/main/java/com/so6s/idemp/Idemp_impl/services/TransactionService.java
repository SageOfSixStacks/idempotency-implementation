package com.so6s.idemp.Idemp_impl.services;

import java.util.List;

import com.so6s.idemp.Idemp_impl.domain.CreateTransactionRequest;
import com.so6s.idemp.Idemp_impl.domain.entity.Transaction;

public interface TransactionService {

  Transaction createTransaction(CreateTransactionRequest request);

  List<Transaction> getTransactions();

  Transaction getTransaction(String idempKey);
}