package vn.funix.fx20081.java.Asm3.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Transaction {//Quản lý giao dich
    private String id;
    private String accountNumber;
    private double amount;
    private String time;
    private boolean status;
    private final LocalDateTime transactionDateTime;
    public Transaction(String accountNumber, double amount, String time, boolean status) {
        this.id = String.valueOf(UUID.randomUUID());;
        this.accountNumber = accountNumber;
        this.amount = amount;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.transactionDateTime = LocalDateTime.parse(time,formatter);
        this.time = String.format(time, formatter);
        this.status = status;
    }
    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }
    public String getId() {
        return id;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
    public String getTime() {
        return time;
    }
    public boolean isStatus() {
        return status;
    }
}
