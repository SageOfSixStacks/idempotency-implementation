package com.so6s.idemp.Idemp_impl.domain.dtos;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.so6s.idemp.Idemp_impl.domain.entity.Currency;

public record TransactionDto(
        UUID id,
        String userId,
        String idempKey,
        BigDecimal amount,
        Currency currency,
        Instant created,
        Instant updated) {
}