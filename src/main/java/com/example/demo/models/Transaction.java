package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private long id;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "tr_datetime")
    private String datetime;
    @Column(name = "mcc_code")
    private int mccCode;
    @Column(name = "tr_type")
    private int type;
    @Column(name = "amount")
    private long amount;
    @Column(name = "term_id")
    private long termId;

    public Transaction() {
        // No-op.
    }

    public Transaction(long id, long customerId, String datetime, int mccCode, int type, long amount, int termId) {
        this.id = id;
        this.customerId = customerId;
        this.datetime = datetime;
        this.mccCode = mccCode;
        this.type = type;
        this.amount = amount;
        this.termId = termId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getMccCode() {
        return mccCode;
    }

    public void setMccCode(int mccCode) {
        this.mccCode = mccCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTermId() {
        return termId;
    }

    public void setTermId(long termId) {
        this.termId = termId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && customerId == that.customerId && mccCode == that.mccCode && type == that.type && amount == that.amount && termId == that.termId && Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, datetime, mccCode, type, amount, termId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", datetime=" + datetime +
                ", mccCode=" + mccCode +
                ", type=" + type +
                ", amount=" + amount +
                ", termId=" + termId +
                '}';
    }
}

// gitflic = govno