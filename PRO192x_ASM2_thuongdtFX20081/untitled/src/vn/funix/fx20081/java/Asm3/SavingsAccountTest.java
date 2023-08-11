package vn.funix.fx20081.java.Asm3;

import org.junit.Test;
import vn.funix.fx20081.java.Asm3.model.SavingsAccount;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @org.junit.Before
    public void setup() {
        savingsAccount = new SavingsAccount("123456");
        savingsAccount.setBalance(5000000);
    }
    @org.junit.Test
    public void withdraw() throws Exception {
        assertTrue( savingsAccount.withdraw(50000));
        assertFalse( savingsAccount.withdraw(6000000));
        savingsAccount.setBalance(100000000);
        assertTrue(savingsAccount.withdraw(6000000));
    }

    @org.junit.Test
    public void isAccepted() throws Exception {
        assertTrue(savingsAccount.isAccepted(50000));
        assertFalse(savingsAccount.isAccepted(40000));
    }
}