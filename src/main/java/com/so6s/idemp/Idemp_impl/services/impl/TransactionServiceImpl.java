package com.so6s.idemp.Idemp_impl.services.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.so6s.idemp.Idemp_impl.domain.CreateTransactionRequest;
import com.so6s.idemp.Idemp_impl.domain.entity.Transaction;
import com.so6s.idemp.Idemp_impl.repository.TransactionRepository;
import com.so6s.idemp.Idemp_impl.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  public TransactionServiceImpl(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Override
  public Transaction createTransaction(CreateTransactionRequest request) {
    Instant now = Instant.now();

    Transaction transaction = new Transaction(
        null,
        request.useId(),
        request.idempKey(),
        request.amount(),
        request.currency(),
        now,
        now);

    return transactionRepository.save(transaction);
  }

  @Override
  public List<Transaction> getTransactions() {
    return transactionRepository.findAll(Sort.by(Direction.ASC, "created"));
  }

  @Override
  public Transaction getTransaction(String idempKey) {
    return transactionRepository.findByIdempKey(idempKey).orElse(null);
  }
}
