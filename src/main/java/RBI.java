import java.io.BufferedReader;
import java.util.*;

public interface RBI {
    final int minBalance = 1000;
    void depositMoney(float amount,Customer obj);
    void withdrawMoney(float amount, Customer obj);
    void openFD(float amount,int years);
    void applyLoan(BufferedReader br, float amount, int years);
    void createRecord(String aadhar, Customer obj);
    void printCustomerDetails(String aadhar);
    boolean getCustomerRecord(String aadharNo);
    void applyCreditCard();
    float getBalance();
}