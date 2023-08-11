package vn.funix.fx20081.java.Asm3;

import org.junit.Test;
import vn.funix.fx20081.java.Asm02.Account;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class AccountTest {
    private Account account;
    @org.junit.Before
    public void setup() {
        account = new Account("123456");
    }
    @org.junit.Test
    public void validateAccount() {// test phương thức xác nhận tài khoản có hợp lệ hay không
        assertTrue(account.validateAccount("123456"));
        assertFalse(account.validateAccount("12a345"));
        assertFalse(account.validateAccount("1234567"));
    }
    @org.junit.Test
    public void isPremium() { //test phương thức isPremium xem có phải là tài khoản premium hay không
        account.setBalance(500000); //set tài khoản 5 trăm nghìn cho tài khoản thường
        assertFalse(account.isPremium());
        account.setBalance(100000000);  //set tài khoản 100 triệu cho tài khoản premium
        assertTrue(account.isPremium());
    }
    @org.junit.Test
    public void getTotalAccountBalance() throws Exception {
        Account account = new Account("123456");
        account.setBalance(50000);
        assertEquals(50000,account.getBalance(),0);
    }
}