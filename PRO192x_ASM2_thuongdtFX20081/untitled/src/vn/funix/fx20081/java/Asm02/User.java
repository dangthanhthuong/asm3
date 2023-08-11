package vn.funix.fx20081.java.Asm02;

import java.util.Scanner;

public class User {
    Scanner sc = new Scanner(System.in);
    private String name;
    private String customerID;
    public User(String name, String customerID){
            if (customerID.equals("No")) {
                this.customerID = null;
            } else {
                try {
                    for (int i = 0; i < customerID.length(); i++) {
                        if ((!Character.isDigit(customerID.charAt(i))) || (customerID.length()!=12)) {
                            throw new Exception("Lỗi: số cccd không đúng điều kiện, vui lòng nhập lại");
                        }
                    }
                    this.customerID = customerID;
                    this.name = name;
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    setCustomerID(sc.next());
                }
            }
        }
    public void setCustomerID(String customerID) {
        if (customerID.equals("No")) {
            this.customerID = null;
        } else {
            try {
                for (int i = 0; i < customerID.length(); i++) {
                    if ((!Character.isDigit(customerID.charAt(i))) || (customerID.length()!=12)) {
                       throw new Exception("Lỗi: số cccd không đúng điều kiện, vui lòng nhập lại");
                    }
                }
                this.customerID = customerID;
            }catch (Exception e){
                System.out.println(e.getMessage());
                setCustomerID(sc.next());
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getCustomerID() {
        return customerID;
    }
}
