import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;

    RBI rbi;
    Customer c1;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
        c1 = new Customer();
    }

    int selectedBank, selectedOperation;
    float depositAmount,withdrawalAmount,amount, ROI, years;
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);
        System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

        switch (obj.selectedBank) {
            case 1:
                obj.rbi = new ICICI();
                break;
            case 2:
                obj.rbi = new HDFC();
                break;
            case 3:
                obj.rbi = new SBI();
                break;
            case 4:
                obj.rbi = new AXIS();
                break;
            case 5:
                obj.rbi = new IDFC();
                break;
        }


        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedOperation);

        obj.c1.balance= 1500.08F;

        switch(obj.selectedOperation)
        {
            case 1:  //Deposit Function
                obj.depositMain();
                break;

            case 2: //Withdrawal Function
                obj.withdrawalMain();
                break;

            case 3: //FD Account
                obj.openFDMain();
                break;

            case 4: //Loan
                obj.applyLoanMain();
                break;

        }

    }

    public void depositMain() {

        float depositAmount = 0;
        System.out.println("Please enter the amount you want to Deposit.");
        try {
            depositAmount = Float.parseFloat(buff.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("The deposit amount is "+depositAmount);
        //call depositMoney fn from RBI class
        //parameters = depositAmount

        rbi.depositMoney(depositAmount,c1);
    }

    public void withdrawalMain() {
        System.out.println("Please enter the amount you want to Withdraw");
        try{
            withdrawalAmount = Float.parseFloat(buff.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("The deposit amount is "+withdrawalAmount);
        //call withdrawMoney fn from RBI interface
        rbi.withdrawMoney(withdrawalAmount,c1);
    }

    public void openFDMain() {
        System.out.println("Please enter you amount and time associated with the FD account.");
        try {
            amount = Float.parseFloat(buff.readLine());
            years = Float.parseFloat(buff.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("FD Account Details");
        System.out.println("Amount:"+amount+"\nYears:"+years);
        //call openFD from RBI interface
        rbi.openFD(amount, (int) years);
    }

    public void applyLoanMain() {
        System.out.println("Please enter the amount and time period of the loan.");
        try {
            amount = Float.parseFloat(buff.readLine());
            years = Float.parseFloat(buff.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        rbi.applyLoan(buff ,amount, (int) years);
    }
}