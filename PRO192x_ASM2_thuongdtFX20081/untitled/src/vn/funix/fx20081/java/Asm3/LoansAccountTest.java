package vn.funix.fx20081.java.Asm3;


import junit.framework.Assert;
import vn.funix.fx20081.java.Asm3.model.LoansAccount;

import static junit.framework.TestCase.*;

public class LoansAccountTest {
    private LoansAccount loansAccount;

    @org.junit.Before
    public void setup() {
        loansAccount = new LoansAccount("654321");
    }
    @org.junit.Test
    public void withdraw() {    //kiểm tra phương thức rút tiền loansAccount
        loansAccount.setBalance(111000000.00);
        assertTrue(loansAccount.withdraw(5000000));
        assertFalse(loansAccount.withdraw(110000000));
    }

    @org.junit.Test
    public void isAccepted() {
        loansAccount.setBalance(5000000);
        loansAccount.withdraw(4000000);
        assertTrue(loansAccount.isAccepted(loansAccount.getBalance()));
        assertFalse(loansAccount.isAccepted(40000));
    }

    @org.junit.Test
    public void getFee() { //kiểm tra phương thức getFee đối với tài khoản thường và tài khoản premium
        loansAccount.setBalance(5000000);//set số dư 5 triệu
        int input = 500000;
        assertEquals(input*0.05,loansAccount.getFee(input),0);
        loansAccount.setBalance(100000000);//set số dư 100 triệu cho tài khoản premium
        Assert.assertEquals(input*0.01,loansAccount.getFee(input),0);
    }
}