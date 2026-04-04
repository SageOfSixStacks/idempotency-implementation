package com.so6s.idemp.Idemp_impl.mapper;

import com.so6s.idemp.Idemp_impl.domain.CreateTransactionRequest;
import com.so6s.idemp.Idemp_impl.domain.dtos.CreateTransactionRequestDto;
import com.so6s.idemp.Idemp_impl.domain.dtos.TransactionDto;
import com.so6s.idemp.Idemp_impl.domain.entity.Transaction;

public interface TransactionMapper {

  CreateTransactionRequest fromDto(CreateTransactionRequestDto dto);

  TransactionDto toDto(Transaction transaction);
}