package vn.funix.fx20081.java.Asm3.model;

import vn.funix.fx20081.java.Asm02.Account;
import vn.funix.fx20081.java.Asm02.Customer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Quản lý thông tin khách hàng tiềm năng
public class DigitalCustomer extends Customer {
    Scanner scanner = new Scanner(System.in);

    private final List<SavingsAccount> savingsAccounts;
    private final List<LoansAccount> loansAccounts;
    private DataTime transactionTime;

    public DigitalCustomer(String name, String customerID) {
        super(name, customerID);
        this.savingsAccounts = new ArrayList<>();
        this.loansAccounts = new ArrayList<>();
        this.transactionTime = new DataTime();
    }

    @Override
    public void displayInformation() {
        String checkPremium;

        if (isPremium()) {
            checkPremium = "Premium";
        } else {
            checkPremium = "Normal";
        }

        DecimalFormat df = new DecimalFormat("#,###");
        String formatSumBalance = df.format(getBalance());
        System.out.printf("%12s%3s%20s%3s%10s%3s%12s%1s%n",getCustomerID(),"|", getName(),"|",
                checkPremium,"|", formatSumBalance, "đ");
        for (int i=0;i<getAccounts().size();i++){
            String formatBalance = df.format(getAccounts().get(i).getBalance());
            if (checkAccountInLoansAccount(getAccounts().get(i))) {
                System.out.printf("%1s%11s%3s%20s%3s%25s%1s%n",(i + 1),getAccounts().get(i).getAccountNumber(),"|","SAVINGS","|",formatBalance,"đ");
            } else {
                System.out.printf("%1s%11s%3s%20s%3s%25s%1s%n",(i + 1),getAccounts().get(i).getAccountNumber(),"|","LOAN", "|",formatBalance,"đ");
            }

        }
    }

@Override
    public void addAccount(Account account) {

    getAccounts().add(account);
    System.out.println("Nhap so du: ");
    double balance = scanner.nextDouble();
    account.setBalance(balance);
    Transaction transaction;
        if (account instanceof SavingsAccount) {
            if (checkAccountInSavingsAccount(account)) {
                System.out.println("Da them so tai khoan ATM vao");
                savingsAccounts.add((SavingsAccount) account);
                transaction = new Transaction(account.getAccountNumber(),balance,transactionTime.getDateTime(),true);
            } else {
                System.out.println("Tai khoan da ton tai, vui long nhap lai");
                transaction = new Transaction(account.getAccountNumber(),balance,transactionTime.getDateTime(),false);
                addAccount(new SavingsAccount(scanner.next()));
            }
            ((SavingsAccount) account).getSavingsTransactionList().add(transaction);
        } else if (account instanceof LoansAccount) {
            if (checkAccountInLoansAccount(account)) {
                System.out.println("Da them so tai khoan tin dung vao");
                loansAccounts.add((LoansAccount) account);
                transaction = new Transaction(account.getAccountNumber(),balance,transactionTime.getDateTime(),true);
            } else {
                System.out.println("Tai khoan da ton tai, vui long nhap lai");
                transaction = new Transaction(account.getAccountNumber(),balance,transactionTime.getDateTime(),false);
                addAccount(new LoansAccount(scanner.next()));
            }
            ((LoansAccount) account).getLoansTransactionList().add(transaction);
        }
    }

    public void withdraw(String accountNumber, double amount) {

        for (SavingsAccount account : getSavingsAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.withdraw(amount)) {
                    account.log(amount);
                    break;
                }
                else {
                    withdraw(accountNumber, scanner.nextDouble());
                    break;
                }
            }
        }
        for (LoansAccount account : getLoansAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.withdraw(amount)) {
                    account.log(amount);
                    break;
                }
                else {
                    withdraw(accountNumber, scanner.nextDouble());
                    break;
                }
            }
        }
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public List<LoansAccount> getLoansAccounts() {
        return loansAccounts;
    }

    public boolean checkAccountInSavingsAccount(Account account) {// Kiểm tra xem account đã có tring list SavingsAccount chưa
        for (SavingsAccount savingsAccount : savingsAccounts) {
            if (account.equals(savingsAccount)) {
                return false;
            }
        }
        return true;

    } public boolean checkAccountInLoansAccount(Account account) {//kiểm tra xem account đã có trong list loansAccount chưa
        for (LoansAccount loansAccount : loansAccounts) {
            if (account.equals(loansAccount)) {
                return false;
            }
        }
        return true;
    }
    public void displayTransaction(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        String formatBalance ;
        for (SavingsAccount account1 : savingsAccounts) {
            for (Transaction transaction : account1.getSavingsTransactionList()) {
                System.out.printf("[GD]%8s%3s%17s%3s%3s%26s%n",transaction.getAccountNumber(),"|",decimalFormat.format(transaction.getAmount()),"đ","|",transaction.getTime());
            }
        }
        for (LoansAccount account1 : loansAccounts) {
            for (Transaction transaction : account1.getLoansTransactionList()) {
                System.out.printf("[GD]%8s%3s%17s%3s%3s%26s%n",transaction.getAccountNumber(),"|",decimalFormat.format(transaction.getAmount()),"đ","|",transaction.getTime());
            }
        }
    }
}

