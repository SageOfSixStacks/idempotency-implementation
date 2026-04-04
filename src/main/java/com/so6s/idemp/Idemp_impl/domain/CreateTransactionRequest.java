package com.so6s.idemp.Idemp_impl.domain;

import java.math.BigDecimal;

import com.so6s.idemp.Idemp_impl.domain.entity.Currency;

public record CreateTransactionRequest(
                String useId,
                String idempKey,
                BigDecimal amount,
                Currency currency) {
}