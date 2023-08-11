package vn.funix.fx20081.java.Asm02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner sc = new Scanner(System.in);
    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {
//        boolean flag = true;
//        for (int i = 0; i < accountNumber.length(); i++) {
//            if (!Character.isDigit(accountNumber.charAt(i))) {
//                flag = false;
//                break;
//            }
//        }
        if (validateAccount(accountNumber)) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("So tài khoản khong hop le.");
            System.out.println("Vui long nhap lai.");
            setAccountNumber(sc.next());
        }
    }

    public void setAccountNumber(String accountNumber) {
//        boolean flag = true;
//        for (int i = 0; i < accountNumber.length(); i++) {
//            if (!Character.isDigit(accountNumber.charAt(i))) {
//                flag = false;
//                break;
//            }
//        }
        if (validateAccount(accountNumber)) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Số tài khoản khong hợp lệ.");
            System.out.println("Vui long nhap lai.");
            setAccountNumber(sc.next());
        }
    }

    public void setBalance(double balance) {
        if(balance<50000.00){
            System.out.println("Số dư nhỏ hơn 50.000đ, yêu cầu nhập lại");
            setBalance(sc.nextDouble());
        }else {
            this.balance = balance;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isPremium(){
        return balance >= 100000000;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("#,###");
        String formatBalance = df.format(balance);
        return String.format("%12s%3s%47s%1s", accountNumber,"|", formatBalance, "đ");
    }
    public boolean validateAccount(String accountNumber) {
        if (accountNumber.length() != 6) {
            return false;
        }
        for (int i = 0; i < accountNumber.length(); i++) {
            if (!Character.isDigit(accountNumber.charAt(i))) {
                return false;

            }
        }
        return true;
    }
}
