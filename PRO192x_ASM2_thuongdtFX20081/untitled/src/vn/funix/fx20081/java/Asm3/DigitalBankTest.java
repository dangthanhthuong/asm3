package vn.funix.fx20081.java.Asm3;

import org.junit.Test;
import vn.funix.fx20081.java.Asm02.Customer;
import vn.funix.fx20081.java.Asm3.model.DigitalBank;

import static org.junit.Assert.*;

public class DigitalBankTest {

    @Test
    public void getCustomerById() { //test phương thức getCustomerById
        DigitalBank bank = new DigitalBank();
        Customer customer = new Customer("Thuong","123456789123");
        bank.addCustomer(customer);
        assertEquals(customer,bank.getCustomerById("123456789123"));
    }
}