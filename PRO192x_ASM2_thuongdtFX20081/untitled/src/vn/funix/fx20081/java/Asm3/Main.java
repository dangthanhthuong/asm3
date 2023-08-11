package vn.funix.fx20081.java.Asm3;

import vn.funix.fx20081.java.Asm02.Account;
import vn.funix.fx20081.java.Asm02.Customer;
import vn.funix.fx20081.java.Asm3.model.DigitalBank;
import vn.funix.fx20081.java.Asm3.model.DigitalCustomer;
import vn.funix.fx20081.java.Asm3.model.LoansAccount;
import vn.funix.fx20081.java.Asm3.model.SavingsAccount;
import java.util.Scanner;

public class Main {
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001215000001";
    private static final String CUSTOMER_NAME = "FUNIX";
    private static void showCustomer() {

        DigitalCustomer customer = (DigitalCustomer) activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
        }
    }
    public static void main(String[] args){
         final String AUTHOR = "FX20081";
         final String VERSION = "@v3.0.0";


        System.out.printf("%1s%15s%3s%3s%1s%20s%n","|","NGAN HANG SO","|",AUTHOR,VERSION,"|");
        System.out.println("+------------+-----------------------+--------------+");
        System.out.println("1. Thoong tin khach hang");
        System.out.println("2. Them tai khoan ATM");
        System.out.println("3. Them tai khoan tin dung");
        System.out.println("4. Rut tien");
        System.out.println("5. Lich su giao dich");
        System.out.println("0. Thoat");
        System.out.println("+------------+-----------------------+--------------+");
        boolean checkKey = true;
//        creatCustomer();
        Customer customer = new DigitalCustomer(CUSTOMER_NAME,CUSTOMER_ID);
       activeBank.addCustomer(customer);
        while (checkKey){
            System.out.print("Chuc nang:");
            int key = functionKey((byte) 5);
            if (key==1) {
                showCustomer();
            }
            if (key == 2) {
                System.out.println("Nhap tai khoan gom 6 chu so: ");
                Account savingsAccount = new SavingsAccount(scanner.next()); //Tạo một savingAccount
                activeBank.addAccount(CUSTOMER_ID,savingsAccount);  //add account đó vào khackh hàng Funix
            }
            if (key == 3) {
                System.out.println("Nhap tai khoan gom 6 chu so: ");
                Account loansAccount = new LoansAccount(scanner.next());
                activeBank.addAccount(CUSTOMER_ID,loansAccount);
            }
            if (key==4) {
                boolean checkWithdrawKey = true;
                while (checkWithdrawKey){
                    System.out.println("Lua chon hinh thuc rut tien:");
                    System.out.println("1. Rut tien tai khoan ATM");
                    System.out.println("2. Rut tien tai khoan tin dung");
                    System.out.println("0. Thoat");
                    int keyWithdraw = functionKey((byte)2);
                    if (keyWithdraw == 1) {
                        System.out.println("Nhap so tai khoan ATM");
                        String savingsWithdraw = scanner.next();
                        activeBank.withdrawSavingAccount(CUSTOMER_ID, savingsWithdraw);
                    }
                    else if (keyWithdraw == 2) {
                        System.out.println("Nhap so tai khoan tin dung");
                        String loansWithdraw = scanner.next();
                        activeBank.withdrawLoansAccount(CUSTOMER_ID, loansWithdraw);
                    } else{
                        checkWithdrawKey = false;
                    }
                }
            }
            if (key==5) {
                showCustomer();
                activeBank.displayTransaction(CUSTOMER_ID);
            }
            if (key==0) {
                checkKey = false;
            }
        }


    }
    public static int functionKey(byte keynumber){ //phím chức năng
        try{
            int key = scanner.nextInt();
            if(key >= 0 && key<=keynumber) {
                return key;
            }else {
                System.out.println("Chức năng không hợp lệ." + " Yêu cầu nhập lại");
                return functionKey(keynumber);
            }
        }catch (Exception e){
            scanner.next();
            System.out.println("Nhập sai dữ liệu." + " Yêu cầu nhập lại");
            return functionKey(keynumber);
        }
    }
}
