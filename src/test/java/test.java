import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    static RBI bank1,bank2,bank3,bank4,bank5;

    @BeforeAll
    public static void init() {
        bank1 = ICICI.getInstance();
        bank2 = HDFC.getInstance();
        bank3 = SBI.getInstance();
        bank4 = AXIS.getInstance();
        bank5 = IDFC.getInstance();
    }

    @Test
    public void testDeposit() {

        float depositAmount = 1000;
        Customer cust = new Customer();
        cust.balance = 1000;
        ArrayList<Float> actRes = new ArrayList<>();
        bank1.depositMoney(depositAmount,cust);
        actRes.add(cust.balance);
        bank2.depositMoney(depositAmount,cust);
        actRes.add(cust.balance);
        bank3.depositMoney(depositAmount,cust);
        actRes.add(cust.balance);
        bank4.depositMoney(depositAmount,cust);
        actRes.add(cust.balance);
        bank5.depositMoney(depositAmount,cust);
        actRes.add(cust.balance);
        assertTrue(new ArrayList<>(Arrays.asList(2000F, 3000F, 4000F, 5000F, 6000F)).equals(actRes));
    }

    @Test
    public void testWithdraw() {
        float withdrawAmount = 1000;
        Customer customer = new Customer();
        customer.balance = 6000;
        ArrayList<Float> actRes = new ArrayList<>();
        bank1.withdrawMoney(withdrawAmount,customer);
        actRes.add(customer.balance);
        bank2.withdrawMoney(withdrawAmount,customer);
        actRes.add(customer.balance);
        bank3.withdrawMoney(withdrawAmount,customer);
        actRes.add(customer.balance);
        bank4.withdrawMoney(withdrawAmount,customer);
        actRes.add(customer.balance);
        bank5.withdrawMoney(withdrawAmount,customer);
        actRes.add(customer.balance);
        assertTrue(new ArrayList<>(Arrays.asList(5000F, 4000F, 3000F, 2000F, 1000F)).equals(actRes));
    }
}
