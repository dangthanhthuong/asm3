package vn.funix.fx20081.java.Asm3.model;
import vn.funix.fx20081.java.Asm02.Account;
import vn.funix.fx20081.java.Asm3.IWithdraw;
import vn.funix.fx20081.java.Asm3.IReportService;


import java.util.ArrayList;
import java.util.List;


// Quản lý tài khoản ATM khách hàng
public class SavingsAccount extends Account implements IReportService, IWithdraw {
    private static final int SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;
    public final DataTime Utils = new DataTime();
    private final List<Transaction> savingsTransactionList;



    public List<Transaction> getSavingsTransactionList() {
        return savingsTransactionList;
    }

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
        this.savingsTransactionList = new ArrayList<>();
    }

    @Override
    public boolean withdraw(double amount) {
        Transaction transaction;
        if (!checkAmount(amount)) {
            return false;
        }
        double newBalance = getBalance()-amount;
        if (isAccepted(newBalance)) {
            System.out.println("Da rut tien ATM thanh cong!");
            setBalance(newBalance);
            transaction = new Transaction(getAccountNumber(), -amount, Utils.getDateTime(), true);
            savingsTransactionList.add(transaction);
            return true;
        }
         transaction = new Transaction(getAccountNumber(),-amount,  Utils.getDateTime(), false);
        savingsTransactionList.add(transaction);
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        if (amount >= 50000) {
            return true;
        }
        return false;
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
        System.out.printf("PHI + VAT: %36s%n", Utils.formatBalance(0));
        System.out.println(Utils.getDivider());
    }

    public boolean checkAmount(double amount) {
        if (amount % 10000 != 0) {
            System.out.println("So tien muon rut phai la boi so cua 10000đ. Vui long nhap lai");
            return false;
        }

        if (amount < 50000) {
            System.out.println("So tien muon rut nho hon 50000đ. Vui long nhap lai");
            return false;
        }
        if (!isPremium()) {
            if (amount > SAVINGS_ACCOUNT_MAX_WITHDRAW) {
                System.out.println("So tien muon rut lớn hơn "+ SAVINGS_ACCOUNT_MAX_WITHDRAW + "đ vui long nhap lai");
                return false;
            }
        }
        return true;
    }

    public String getTitle() {
        return "BIEN LAI GIAO DICH SAVINGS";
    }
}
