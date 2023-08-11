package vn.funix.fx20081.java.Asm3;

import org.junit.Test;
import vn.funix.fx20081.java.Asm02.Account;
import vn.funix.fx20081.java.Asm02.Bank;
import vn.funix.fx20081.java.Asm02.Customer;

import static org.junit.Assert.*;

public class BankTest {
    private Bank bank;
    private Customer customer;
    @org.junit.Before
    public void setup() {
        bank = new Bank();
        Customer customer = new Customer("thuong", "123456789123");
        bank.addCustomer(customer);

    }
    @Test
    public void isCustomerExisted() {// test phương thức isCustomerExisted xem CCCD đã tồn tại trong hệ thống hay chưa
        assertTrue(bank.isCustomerExisted("123456789123")); //CCCD đã tồn tại trong hệ thống
        assertFalse(bank.isCustomerExisted("987654321987"));    //CCCD chưa tồn tại trong trong hệ thống
    }

    @org.junit.Test
    public void isAccountExisted() {
        Account account = new Account("123456");
        bank.addAccount("123456789123",account);
        Account input1 = new Account("123456");
        Account input2 = new Account("321654");
        assertFalse(bank.isAccountExisted(input1)); // xác nhận tài khoản đã tồn tại
    }
}