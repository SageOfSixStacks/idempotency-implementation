package com.so6s.idemp.Idemp_impl.domain.dtos;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.so6s.idemp.Idemp_impl.domain.entity.Currency;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTransactionRequestDto(
    @NotBlank(message = ERROR_MESSAGE_USERID_LENGTH) @Length(min = 36, max = 36, message = ERROR_MESSAGE_USERID_LENGTH) String userId,
    @NotBlank(message = ERROR_MESSAGE_IMDEMPKEY_LENGTH) @Length(min = 36, max = 36, message = ERROR_MESSAGE_IMDEMPKEY_LENGTH) String idempKey,
    @DecimalMin(value = "0.0", inclusive = false, message = ERROR_MESSAGE_AMOUNT) BigDecimal amount,
    @NotNull(message = ERROR_MESSAGE_CURRENCY) Currency currency) {
  private static final String ERROR_MESSAGE_USERID_LENGTH = "User Id must be 36 characters long";
  private static final String ERROR_MESSAGE_IMDEMPKEY_LENGTH = "Idempotency key must be 36 characters long";
  private static final String ERROR_MESSAGE_AMOUNT = "Amount must be greater than 0.0";
  private static final String ERROR_MESSAGE_CURRENCY = "Currency must be provided";
}