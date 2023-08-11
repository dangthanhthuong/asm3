package vn.funix.fx20081.java.Asm02;

import java.util.Scanner;

public class Main {
    private static final Bank bank = new Bank();
    public static Scanner sc = new Scanner(System.in);
    static final String AUTHOR = "FX20081";
    static final String VERSION = "@v2.0.0";
    public static void main(String[] args){
        System.out.println("+-----------+----------------------+-------------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + VERSION + "                  |");
        System.out.println("+-----------+----------------------+-------------+");
        System.out.println("1. Them ngan hang");
        System.out.println("2. Them tai khoan cho ngan hang");
        System.out.println("3. Hien thi danh sach khach hang");
        System.out.println("4. Tim theo CCCD");
        System.out.println("5. Tim theo ten khach hang");
        System.out.println("0. Thoat");
        System.out.println("+-----------+----------------------+-------------+");
        boolean flag = true;
        while (flag){
        System.out.print("Chuc nang:");
        int functionKey = functionKey((byte) 6);
            if(functionKey == 1){ //thêm khách hàng
                System.out.println("+------------------------------------------------+");
                System.out.print("Nhập tên khách hàng: ");
                String name = sc.next();
                System.out.print("Nhập số CCCD: ");
                String CustomerID = sc.next();
                bank.addCustomer(new Customer(name,CustomerID));
            }

            if(functionKey==2){//thêm tài khoản cho ngân hàng
               addAccount();
            }

            if (functionKey == 3) { //hiển thị danh sách khách hàng
                for(Customer customer:bank.getCustomers()){
                customer.displayInformation();
                }
            }

            if (functionKey == 4) { //Tìm theo CCCD khách hàng
                System.out.println("Nhập số CCCD: ");
                String CustomerID = sc.next();
                    for (Customer customer : bank.getCustomers()) {
                        if (customer.getCustomerID().contains(CustomerID)) {
                            customer.displayInformation();
                            break;
                        }
                    }
            }

            if (functionKey==5) { // Tìm theo tên gần đúng của khách hàng
                searchName();
            }

            if (functionKey==0){
                flag = false;
            }
        }
    }

    public static int functionKey(byte keynumber){ //phím chức năng
        try{
            int key = sc.nextInt();
            if(key >= 0 && key<=keynumber) {
                return key;
            }else {
                System.out.println("Chức năng không hợp lệ." + " Yêu cầu nhập lại");
                return functionKey(keynumber);
            }
        }catch (Exception e){
            sc.next();
            System.out.println("Nhập sai dữ liệu." + " Yêu cầu nhập lại");
            return functionKey(keynumber);
        }
    }

    public static void addAccount(){// Thêm tài khoản cho ngân hàng
        System.out.println("Nhập số CCCD: ");
        String CustomerID = sc.next();
        if (CustomerID.equals("No")){
            System.out.println(" ");
        }else {
            if (bank.isCustomerExisted(CustomerID)) {
                System.out.println("Nhập số tài khoản");
                bank.addAccount(CustomerID, new Account(sc.next()));
            } else {
                addAccount();
            }
        }
    }
    public static void searchName() { // Tìm theo tên gần đúng của khách hàng
        System.out.println("Nhập tên khách hàng: ");
        String keyword = sc.next();
        boolean fleg = false;
        for (Customer customer : bank.getCustomers()){
            if (customer.getName().contains(keyword)) {
                fleg = true;
                break;
            }
        }
        if (fleg) {
            for (Customer customer : bank.getCustomers()) {
                if (customer.getName().contains(keyword)) {
                    customer.displayInformation();
                }
            }
        } else {
            System.out.println("Không tìm thấy tên khách hàng, Vui lòng nhập lại");
            searchName();
        }
    }
}
