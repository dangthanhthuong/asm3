package vn.funix.fx20081.java.Asm02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Bank {
    static Scanner sc = new Scanner(System.in);
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }


    public void addCustomer(Customer newCustomer){
        if (newCustomer.getCustomerID()==null){
            System.out.println("đã thoát");
        }else {
            if(this.customers.isEmpty()){
                customers.add(newCustomer);
                System.out.println("Đã thêm khách hàng "+ newCustomer.getCustomerID() + " vào danh sách");
            }
            else{
                boolean flag = true;

                for(Customer customer : customers) {
                    if (newCustomer.getCustomerID().equals(customer.getCustomerID())) {
                        System.out.println("CCCD đã tồn tại vui long nhập lại");
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    System.out.println("Đã thêm khách hàng "+ newCustomer.getCustomerID() + " vào danh sách");
                    customers.add(newCustomer);
                }else {
                    System.out.print("Nhập tên khách hàng: ");
                    String name = sc.next();
                    System.out.print("Nhập số CCCD: ");
                    String CustomerID = sc.next();
                    addCustomer(new Customer(name, CustomerID));
                }
            }
        }
    }
    public void addAccount(String customerID, Account account) {
        if(isAccountExisted(account)){
            for(Customer checkCustomer:customers){
                if (customerID.equals(checkCustomer.getCustomerID())) {
//                    System.out.print("Đã thêm số tài khoản vào ");
                    checkCustomer.addAccount(account);
                    break;
                }
            }
        }
        else {
            System.out.println("Tài khoản đã tồn tại, vui lòng nhập lại.");
            System.out.println("Nhập lại số tài khoản: ");
            addAccount(customerID, new Account(sc.next()));
        }
    }


    public boolean isCustomerExisted(String customerID){
            if (validateCustomer(customerID)) {

                for(Customer checkCustomer:customers){
                    if (customerID.equals(checkCustomer.getCustomerID())) {
                        return true;
                    }
                }
                System.out.println("Số CCCD không tồn tại vui lòng nhập lại");
                return false;
            } else {
                System.out.println("So CCCD khong hop le.");
                System.out.println("Vui long nhap lai");
                return false;
            }

    }
    public List<Customer> getCustomers(){

        return customers;
    }

    public boolean isAccountExisted( Account account) {
        for (Customer customer : customers) {
            for(Account checkAccount:customer.getAccounts()){
                if (account.getAccountNumber().equals(checkAccount.getAccountNumber())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateCustomer(String customerID) {
        if (customerID.length() != 12) {
            return false;
        }
        for (int i = 0; i < customerID.length(); i++) {
            if (!Character.isDigit(customerID.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
