package vn.funix.fx20081.java.Asm3.model;

import vn.funix.fx20081.java.Asm02.Account;
import vn.funix.fx20081.java.Asm3.IReportService;
import vn.funix.fx20081.java.Asm3.IWithdraw;

import java.util.ArrayList;
import java.util.List;
//Quản lý tài khoản tín dụng khách hàng

public class LoansAccount extends Account implements IReportService, IWithdraw {
    private static final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05; // phí rút tiền cho tài khoản thường
    private static final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;   //Phí rút tiền cho tài khoản premium
    private static final int LOAN_ACCOUNT_MAX_BALANCE = 100000000;  //Hạn mức tối đa cho tài khoản này
    public final DataTime Utils = new DataTime();
    private final List<Transaction> loansTransactionList;

    public List<Transaction> getLoansTransactionList() {
        return loansTransactionList;
    }

    public LoansAccount(String accountNumber) {
        super(accountNumber);
        this.loansTransactionList = new ArrayList<>();
    }
    @Override
    public boolean withdraw(double amount) {
        Transaction transaction;
        if (!checkAmount(amount)) {
            return false;
        }
        double newBalance = getBalance() - amount - getFee(amount);
        if (isAccepted(newBalance)) {
            System.out.println("Da rut tien tin dung thanh cong");
            setBalance(newBalance);
            transaction = new Transaction(getAccountNumber(), -amount, Utils.getDateTime(), true);
            loansTransactionList.add(transaction);
            return true;
        }
        transaction = new Transaction(getAccountNumber(), -amount, Utils.getDateTime(), false);
        loansTransactionList.add(transaction);
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        if (amount < 50000) {
            System.out.println("Han muc con lai khi rut tien khong duoc nho hon 50.000đ");
            return false;
        }
        return true;
    }
    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%35s%n", getTitle());
        System.out.printf("NGAY B/D: %37s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %39s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SB TK: %40s%n", getAccountNumber());
        System.out.printf("SO TIEN: %38s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %40s%n", Utils.formatBalance(getBalance()));
        System.out.printf("PHI + VAT: %36s%n", Utils.formatBalance(getFee(amount)));
        System.out.println(Utils.getDivider());
    }


    public boolean checkAmount(double amount) {
        if (amount > LOAN_ACCOUNT_MAX_BALANCE) {
            System.out.println("Han muc khong dược vượt quá 100.000.000đ");
            return false;
        }
        return true;
    }

    public double getFee(double amount) {
        if (!isPremium()) {
            return amount*LOAN_ACCOUNT_WITHDRAW_FEE;
        }
        return amount*LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE;
    }


    public String getTitle() {
        return "BIEN LAI GIAO DICH LOAN";
    }
}
