package com.so6s.idemp.Idemp_impl.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.so6s.idemp.Idemp_impl.domain.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
  Optional<Transaction> findByIdempKey(String idempKey);
}