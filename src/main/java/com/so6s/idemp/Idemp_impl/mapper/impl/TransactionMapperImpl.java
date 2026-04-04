package com.so6s.idemp.Idemp_impl.mapper.impl;

import org.springframework.stereotype.Component;

import com.so6s.idemp.Idemp_impl.domain.CreateTransactionRequest;
import com.so6s.idemp.Idemp_impl.domain.dtos.CreateTransactionRequestDto;
import com.so6s.idemp.Idemp_impl.domain.dtos.TransactionDto;
import com.so6s.idemp.Idemp_impl.domain.entity.Transaction;
import com.so6s.idemp.Idemp_impl.mapper.TransactionMapper;

@Component
public class TransactionMapperImpl implements TransactionMapper {

  @Override
  public CreateTransactionRequest fromDto(CreateTransactionRequestDto dto) {
    return new CreateTransactionRequest(
        dto.userId(),
        dto.idempKey(),
        dto.amount(),
        dto.currency());
  }

  @Override
  public TransactionDto toDto(Transaction transaction) {
    return new TransactionDto(
        transaction.getId(),
        transaction.getUserId(),
        transaction.getIdempKey(),
        transaction.getAmount(),
        transaction.getCurrency(),
        transaction.getCreated(),
        transaction.getUpdated());
  }

}
