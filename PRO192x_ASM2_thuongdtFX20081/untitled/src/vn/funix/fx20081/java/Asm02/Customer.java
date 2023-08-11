package vn.funix.fx20081.java.Asm02;

import vn.funix.fx20081.java.Asm3.model.SavingsAccount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
private final List<Account> accounts;
Scanner sc = new Scanner(System.in);
    public Customer(String name, String customerID) {
        super(name, customerID);
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public boolean isPremium(){
        boolean flag = false;
        for(Account account:accounts){
            if (account.isPremium()) {
                flag=true;
                break;
            }
        }
        return flag;
    }
    public void addAccount(Account account){
        accounts.add(account);
        System.out.println("Nhap so du: ");
        double balance = sc.nextDouble();
        account.setBalance(balance);
    }
    public double getBalance(){
        double sumBalance = 0;
        for (Account account:accounts){
            sumBalance += account.getBalance();
        }
        return sumBalance;
    }
    public void displayInformation(){
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
        for (int i=0;i<accounts.size();i++){
            System.out.println((i+1) + accounts.get(i).toString());
        }
    }
}

