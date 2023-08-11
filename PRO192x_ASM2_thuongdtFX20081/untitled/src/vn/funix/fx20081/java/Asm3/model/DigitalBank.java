package vn.funix.fx20081.java.Asm3.model;

import vn.funix.fx20081.java.Asm02.Account;
import vn.funix.fx20081.java.Asm02.Bank;
import vn.funix.fx20081.java.Asm02.Customer;

import java.util.Scanner;

public class DigitalBank extends Bank {
    Scanner scanner = new Scanner(System.in);
    public DigitalBank() {
        super();
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()) {
            if (customer.getCustomerID().equals(customerId)) {
                return customer;
            }
        }
        System.out.println("Không tìm thấy khách hàng, yêu cầu nhập lại");
        return getCustomerById(scanner.next());
    }

    @Override
    public void addAccount(String customerID,Account account) {
        if (account instanceof SavingsAccount) {
            if (isAccountExisted(account)) {
                super.addAccount(customerID, account);
            } else {
                System.out.println("Tài khoản đã tồn tại, vui lòng nhập lại.");
                System.out.println("Nhập lại số tài khoản: ");
                addAccount(customerID,new SavingsAccount(scanner.next()));
            }
        } if (account instanceof LoansAccount) {
            if (isAccountExisted(account)) {
                super.addAccount(customerID, account);
            } else {
                System.out.println("Tài khoản đã tồn tại, vui lòng nhập lại.");
                System.out.println("Nhập lại số tài khoản: ");
                addAccount(customerID,new LoansAccount(scanner.next()));
            }
        }

    }

    public void withdrawSavingAccount(String customerID, String account) {
        DigitalCustomer digitalCustomer = (DigitalCustomer) getCustomerById(customerID);
        boolean isSavingAcount = false;
        for (SavingsAccount savingsAccount : digitalCustomer.getSavingsAccounts()) {
            if (account.equals(savingsAccount.getAccountNumber())) {
                isSavingAcount = true;
                break;
            }
        }
        boolean savingsOrLoans = true;
        withDraw(savingsOrLoans,isSavingAcount,customerID,account,digitalCustomer);
    }


    public void withdrawLoansAccount(String customerID, String account) {
        DigitalCustomer digitalCustomer = (DigitalCustomer) getCustomerById(customerID);
        boolean isLoansAcount = false;
        for (LoansAccount loansAccount : digitalCustomer.getLoansAccounts()) {
            if (account.equals(loansAccount.getAccountNumber())) {
                isLoansAcount = true;
                break;
            }
        }
        boolean savingsOrLoans = false;
        withDraw(savingsOrLoans,isLoansAcount,customerID,account,digitalCustomer);
    }
    public void withDraw(boolean savingsOrLoans,boolean withDraw,String customerID, String account, DigitalCustomer digitalCustomer) {
        if (withDraw) {
            System.out.println("Nhap so tien muon rut: ");
            double amount = scanner.nextDouble();
            digitalCustomer.withdraw(account, amount);
        } else {
            if (savingsOrLoans) {
                System.out.println("So tai khoan ATM khong ton tai, vui long nhap lại");
                withdrawSavingAccount(customerID, scanner.next());
            } else {
                System.out.println("So tai khoan tin dung khong ton tai, vui long nhap lại");
                withdrawLoansAccount(customerID, scanner.next());
            }
        }
    }
    public void displayTransaction(String customerID) {
        DigitalCustomer digitalCustomer = (DigitalCustomer) getCustomerById(customerID);
        if (digitalCustomer != null) {
            digitalCustomer.displayTransaction();
        } else {
            System.out.println("So CCCD khong ton tai");
            displayTransaction(scanner.next());
        }
    }
}
