package com.so6s.idemp.Idemp_impl.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.so6s.idemp.Idemp_impl.domain.CreateTransactionRequest;
import com.so6s.idemp.Idemp_impl.domain.dtos.CreateTransactionRequestDto;
import com.so6s.idemp.Idemp_impl.domain.dtos.TransactionDto;
import com.so6s.idemp.Idemp_impl.domain.entity.Transaction;
import com.so6s.idemp.Idemp_impl.mapper.TransactionMapper;
import com.so6s.idemp.Idemp_impl.services.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

  private final TransactionService transactionService;
  private final TransactionMapper transactionMapper;

  public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
    this.transactionService = transactionService;
    this.transactionMapper = transactionMapper;
  }

  @PostMapping
  public ResponseEntity<TransactionDto> createTransaction(
      @Valid @RequestBody CreateTransactionRequestDto createTransactionRequestDto) {
    // Enforcing idempotency
    String idempKey = createTransactionRequestDto.idempKey();
    Transaction exist = transactionService.getTransaction(idempKey);

    // If a transaction already exist in the database we return that transaction
    // rather
    if (exist != null) {
      TransactionDto transactionDto = transactionMapper.toDto(exist);
      return new ResponseEntity<>(transactionDto, HttpStatus.OK);
    }

    // If no transaction with that idempKey is found we create a new transaction
    CreateTransactionRequest createTransactionRequest = transactionMapper.fromDto(createTransactionRequestDto);
    Transaction transaction = transactionService.createTransaction(createTransactionRequest);
    TransactionDto createdTransaction = transactionMapper.toDto(transaction);
    return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TransactionDto>> getTransactions() {
    List<Transaction> transaction = transactionService.getTransactions();
    List<TransactionDto> transactionDtos = transaction.stream().map(transactionMapper::toDto).toList();
    return new ResponseEntity<>(transactionDtos, HttpStatus.OK);
  }

}