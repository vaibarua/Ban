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
        rbi = new RBI();
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
                System.out.println("Please enter the amount you want to Deposit.");
                try {
                    obj.depositAmount = Float.parseFloat(obj.buff.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The deposit amount is "+obj.depositAmount);
                //call depositMoney fn from RBI class
                //parameters = depositAmount

                obj.rbi.depositMoney(obj.depositAmount,obj.c1);
                break;

            case 2: //Withdrawal Function
                System.out.println("Please enter the amount you want to Withdraw");
                try{
                    obj.withdrawalAmount = Float.parseFloat(obj.buff.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                System.out.println("The deposit amount is "+obj.withdrawalAmount);
                //call withdrawMoney fn from RBI class
                obj.rbi.withdrawMoney(obj.withdrawalAmount,obj.c1);
                break;

            case 3: //FD Account
                System.out.println("Please enter you amount and time associated with the FD account.");
                try {
                    obj.amount = Float.parseFloat(obj.buff.readLine());
                    obj.years = Float.parseFloat(obj.buff.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                System.out.println("FD Account Details");
                System.out.println("Amount:"+obj.amount+"\nYears:"+obj.years);
                //call openFD from RBI class
                obj.rbi.openFD(obj.amount,obj.years);
                break;

            case 4: //Loan
                System.out.println("Please enter the amount and time period of the loan.");
                try {
                    obj.amount = Float.parseFloat(obj.buff.readLine());
                    obj.years = Float.parseFloat(obj.buff.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                obj.rbi.applyLoan("Loan",obj.amount, (int) obj.years);

        }

    }
}