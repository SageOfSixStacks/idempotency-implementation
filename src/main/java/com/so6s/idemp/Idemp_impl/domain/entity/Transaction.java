package com.so6s.idemp.Idemp_impl.domain.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "user_id", nullable = false, updatable = false, length = 36)
  private String userId;

  @Column(name = "idemp_key", unique = true, nullable = false, updatable = false, length = 36)
  private String idempKey;

  @Column(name = "amount", nullable = false, updatable = false, precision = 12, scale = 2)
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  @Column(name = "currency", nullable = false, updatable = false)
  private Currency currency;

  @Column(name = "created", nullable = false, updatable = false)
  private Instant created;

  @Column(name = "updated", nullable = false)
  private Instant updated;

  public Transaction() {
  }

  public Transaction(UUID id, String userId, String idempKey, BigDecimal amount, Currency currency, Instant created,
      Instant updated) {
    this.id = id;
    this.userId = userId;
    this.idempKey = idempKey;
    this.amount = amount;
    this.currency = currency;
    this.created = created;
    this.updated = updated;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getIdempKey() {
    return idempKey;
  }

  public void setIdempKey(String idempKey) {
    this.idempKey = idempKey;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public Instant getCreated() {
    return created;
  }

  public void setCreated(Instant created) {
    this.created = created;
  }

  public Instant getUpdated() {
    return updated;
  }

  public void setUpdated(Instant updated) {
    this.updated = updated;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Transaction other = (Transaction) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Transaction [id=" + id + ", userId=" + userId + ", idempKey=" + idempKey + ", amount=" + amount
        + ", currency=" + currency + ", created=" + created + ", updated=" + updated + "]";
  }
}