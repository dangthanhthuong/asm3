package vn.funix.fx20081.java.Asm01;

import java.util.ArrayList;

public class GenderAndAgeNumber {
    // Tuổi và giới tính
    public static boolean genderAge(int key,int bird){
       int[] year = new int[10];
       year[0] = 1900;
       year[1] = 1900;
       year[2] = 2000;
       year[3] = 2000;
       year[4] = 2100;
       year[5] = 2100;
       year[6] = 2200;
       year[7] = 2200;
       year[8] = 2300;
       year[9] = 2300;

       String[] gender = new String[10];
       for(int i=0;i<gender.length;i++){
           if(i%2==0) {
               gender[i] = "Nam";
           }else {
               gender[i] = "Nu";
           }
       }
        System.out.println("Gioi tinh: " + gender[key] + " | " + (year[key]+bird));
       return true;
    }
}
