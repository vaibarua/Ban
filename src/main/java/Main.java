import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main implements Runnable {

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
    String aadharNo,createAccount,redirectToBank;
    float withdrawalAmount,amount, years;
    public static void main(String[] args)  {
        Main obj = new Main();
        Thread t = new Thread(obj);
        t.start();
    }

    @Override
    public void run() {
        boolean flag =true;
        temp: while(true) {
            SelectBank();
            switch (selectedBank) {
                case 1:
                    rbi = ICICI.getInstance();
                    break;
                case 2:
                    rbi = HDFC.getInstance();
                    break;
                case 3:
                    rbi = SBI.getInstance();
                    break;
                case 4:
                    rbi = AXIS.getInstance();
                    break;
                case 5:
                    rbi = IDFC.getInstance();
                    break;
                case 6:
                    break temp;

            }
            flag = true;
            while (flag) {
                System.out.println("Please enter your Aadhar Number:");
                try {
                    aadharNo = buff.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (rbi.getCustomerRecord(aadharNo)) {
                    SelectOperations();
                }
                else {
                    System.out.println("You do not have an account with your registered Aadhar Number.");
                    System.out.println("Do you want to create an account? Type YES/NO");
                    try {
                        createAccount = buff.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (createAccount.equals("YES")) {
                        Customer newCustomer = createNewCustomer();
                        rbi.createRecord(newCustomer.customerAadhar,newCustomer);
                        System.out.println("Your account has been created with the following Details.");
                        SelectOperations();

                    }
                    else {
                        continue;
                    }
                }
                System.out.println("Do you want to return to Bank Menu? Type YES/NO");
                try {
                    redirectToBank = buff.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(redirectToBank.equals("YES")) continue;
                else flag=false;
            }
        }
    }


    public void SelectBank () {
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC\nPRESS 6 TO EXIT");
        try {
            selectedBank = Integer.parseInt(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + selectedBank);
    }

    public void SelectOperations() {
        System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");
        try {
            selectedOperation = Integer.parseInt(buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        switch (selectedOperation) {
                        case 1:  //Deposit Function
                            depositMain();
                            break;

                        case 2: //Withdrawal Function
                            withdrawalMain();
                            break;

                        case 3: //FD Account
                            openFDMain();
                            break;

                        case 4: //Loan
                            applyLoanMain();
                            break;

                    }

    }

    public String newStringInput(String x) {
        try{
            x = buff.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return x;
    }

    public Customer createNewCustomer() {
        String customerName = null, customerEmail = null, customerAddress = null, customerGender = null, customerAadhar = null, customerPhone = null;
        System.out.println("Enter Name: ");
        customerName=newStringInput(customerName);
        System.out.println("Enter Address: ");
        customerAddress=newStringInput(customerAddress);
        System.out.println("Enter Gender: ");
        customerGender=newStringInput(customerGender);
        System.out.println("Enter Aadhar Number: ");
        customerAadhar=newStringInput(customerAadhar);
        System.out.println("Enter Email: ");
        customerEmail=newStringInput(customerEmail);
        System.out.println("Enter Phone Number: ");
        customerPhone=newStringInput(customerPhone);
        return new Customer(customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone,0.0F);
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