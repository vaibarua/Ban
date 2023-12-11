import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class SBI implements  RBI{

    final String[] loanTypes = {"Personal","Home","Car","Educational"};
    float ROI;
    HashMap<String,Customer> record;
    private static SBI instance = null;

    private SBI() {
        ROI=0.0F;
        record=new HashMap<>();
    }

    public static SBI getInstance() {
        if (instance == null) {
            instance = new SBI();
        }
        return instance;
    }

    @Override
    public void depositMoney(float amount, Customer obj) {
        obj.balance = obj.balance + amount;
        System.out.println("You have successfully deposited the amount. Current balance is :"+obj.balance);
    }

    @Override
    public void withdrawMoney(float amount, Customer obj) {
        if(amount>obj.balance)
        {
            System.out.println("You do not have sufficient balance to Withdraw");
        }
        else if(obj.balance-amount<1000)
        {
            System.out.println("Cannot Withdraw. Minimum balance won't be maintained.");
        }
        else
        {
            obj.balance = obj.balance - amount;
            System.out.println("You have successfully withdrawn the amount. Current balance is :"+obj.balance);
        }
    }

    @Override
    public void openFD(float amount, int years) {
        float ROI = 9.5F;
        float maturedAmount=amount;
        for(int i=1;i<=years;i++) {
            maturedAmount+= ((ROI*maturedAmount)/100);
            System.out.println("Amount after Year"+i+": "+maturedAmount);
        }
        System.out.println("Total Profit: "+(maturedAmount-amount));

    }

    @Override
    public void applyLoan(BufferedReader buff, float amount, int years) {
        int loanType = 0;
        System.out.println("Please enter Loan type\n1. Personal\n2. Home\n3. Car\n4. Educational");
        try{
            loanType = Integer.parseInt(buff.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        float interest;
        switch (loanType) {
            case 1 :
                ROI = 10;
                break;
            case 2:
                ROI = 5;
                break;
            case 3:
                ROI = 8;
                break;
            case 4:
                ROI = 4;
                break;
        }
        interest = (amount*ROI*years)/100;
        float rbiCharges = interest/100;
        System.out.println("Loan Type: "+loanTypes[loanType-1]);
        System.out.println("Total interest: "+interest);
        System.out.println("Outstanding amount after interest: "+(amount+interest));
        System.out.println("RBI charges: "+rbiCharges);
    }

    @Override
    public void createRecord(String aadhar, Customer obj) {
        record.put(aadhar,obj);
    }

    @Override
    public boolean getCustomerRecord(String aadharNo) {
        return record.containsKey(aadharNo);
    }

    @Override
    public int getNumberOfCustomers() { return record.size(); }

    public void printCustomerDetails(String aadharNo) {
        if (getCustomerRecord(aadharNo))
        {
            Customer obj = record.get(aadharNo);
            System.out.println(obj.toString());
        }
    }

    @Override
    public void applyCreditCard() {
    }

    @Override
    public float getBalance(String aadharNo) {
        Customer obj = record.get(aadharNo);
        return obj.balance;
    }

    public Boolean checkMinimumBalance(int balance) {
        return balance >= 2 * minBalance;
    }
}