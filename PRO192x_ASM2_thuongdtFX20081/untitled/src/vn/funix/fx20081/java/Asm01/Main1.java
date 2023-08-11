package vn.funix.fx20081.java.Asm01;

import java.util.*;

public class Main1 {
     public static Scanner sc = new Scanner(System.in);
     static final String AUTHOR = "FX20081";
     static final String VERSION = "@v1.0.0";

    public static void main(String[] args) {

        System.out.println("+-------------+------------------------+-------------+");
        System.out.println("| NGAN HANG SO | " + AUTHOR + VERSION + "                      |");
        System.out.println("| 1. Nhap CCCD                                       |");
        System.out.println("| 0. Thoat                                           |");
        System.out.println("+-------------+------------------------+-------------+");
        System.out.print("Chuc nang: ");

        boolean checkKey = functionKey();
            String select;
        if(checkKey){
            System.out.println("1. Ma xac thuc EASY.");
            System.out.println("2. Ma xac thuc HARD.");
            System.out.print("Chon phuong thuc nhap: ");

            boolean checkOption = option();

            if (checkOption){
            select = select1();
        }else {
            select = select2();
        }
            System.out.println("Nhap ma xac thuc: " + select);
            boolean checkCode = verificationCodes(select);

            if(checkCode){
                System.out.print("Vui long nhap so CCCD: ");
                boolean fleg = true;
                String cccdNumber = "044099003068";

                while (fleg){
                    String cccd = sc.next();

                    if (cccd.equals("No")){
                        //Nhập No để thoát
                        break;
                    }else {
                        boolean flag = true;
                        for(int i=0;i<cccd.length();i++){
                            if(!Character.isDigit(cccd.charAt(i))) {
                                flag = false;
                                break;
                            }
                        }

                        if (cccd.length() == 12 && flag){
                            cccdNumber = cccd;
                            fleg = false;
                        }

                        else {
                            System.out.println("So CCCD khong hop le.");
                            System.out.println("Vui long nhap lai hoac 'No' de thoat");
                        }
                    }
                }

                while (!fleg){
                    System.out.println(" | 1. kiem tra noi sinh");
                    System.out.println(" | 2. Kiem tra tuoi, gioi tinh");
                    System.out.println(" | 3. Kiem tra so ngau nhien");
                    System.out.println(" | 0. Thoat");
                    System.out.print("Chuc nang:");

                    try {   //phím chon chức năng của CCCD
                        byte key = sc.nextByte();
                        if(key == 1){
                            String address = cccdNumber.substring(0,3);

                            IDnumber.ID(address);
                            continue;
                        } else if (key==2) {
                            int genderAge = Integer.parseInt(cccdNumber.substring(3,4));
                            int bird = Integer.parseInt(cccdNumber.substring(4,6));
                            GenderAndAgeNumber.genderAge(genderAge,bird);
                            continue;
                        } else if (key==3) {
                            System.out.println(cccdNumber.substring(6));
                            continue;
                        } else if (key==0) {
                            System.out.println("Ket thuc chuong trinh");
                            break;
                        }
                        else {
                            System.out.println("Yeu cau nhap lai");
                            continue;
                        }
                    } catch (Exception e) {
                        sc.nextLine();
                        System.out.println("data type error. Yeu cau nhap lai");
                        continue;
                    }

                }
            }
        }
    }




    public static boolean functionKey() { //Phím xác thực chức năng

        try{    //try-catch xử lý ngoai lệ nhập từ bàn phím int
        int key = sc.nextInt();
            if (key == 1) {
                return true;
            } else if (key == 0) {
                return false;
            } else {
                System.out.println("Yeu cau nhap lai");
                return functionKey();
            }
        }
        catch (Exception e ){
            sc.nextLine();
            System.out.println("data type error. " + " Yeu cau nhap lai");
            return functionKey();
        }

    }

    public static boolean option(){ //Phím lựa chọn nhập mã xác thực
        try {
            int selectNumber = sc.nextInt();
            if (selectNumber == 1) {
                sc.nextLine();
                return true;
            } else if (selectNumber == 2) {
                sc.nextLine();
                return false;
            } else {
                System.out.println("Vui long nhap lai");
                return option();
            }
        }catch (Exception e) {
            sc.nextLine();
            System.out.println("data type error. Vui long nhap lai");
            return option();
        }
    }
    public static String select1(){ //Mã xác thưc EASY
    Random random = new Random();
    int code = random.nextInt(900) +100;
    String password = String.valueOf(code);
    return password;
    }
public static String select2(){//Mã xác thực HARD
    String capotalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    String allChars = capotalCaseLetters + lowerCaseLetters + numbers;
    Random random = new Random();
    char[] password = new char[6];
            for(int i=0; i<6;i++){
        password[i] = allChars.charAt(random.nextInt(allChars.length()));
    }
            return new String(password);
}



    public static boolean verificationCodes(String code){   //Xác thực mã xác thục
        String insertCode = sc.nextLine();
        if (insertCode.equals(code)){
            return true;
        }else {
            System.out.println("Ma xac thuc sai.Vui long nhap lai");
            return verificationCodes(code);
        }

    }

}