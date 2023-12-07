public class RBI {
    float balance;

    public RBI() {
        balance = 1000.0F;
    }

    public void depositMoney(float amount, Customer obj) { //pass Customer object later
        obj.balance = obj.balance + amount;
        System.out.println("You have successfully deposited the amount. Current balance is :"+obj.balance);
    }
    public void withdrawMoney(float amount, Customer obj){ //pass Customer object later
        if(amount>obj.balance)
        {
            System.out.println("You do not have enough balance to Withdraw");
        }
        else
        {
            obj.balance = obj.balance - amount;
            System.out.println("You have successfully withdrawn the amount. Current balance is :"+obj.balance);
        }
    }
    public void openFD(float amount, float years) {
        float ROI = 6.5F;
        float maturedAmount=amount;
        for(int i=1;i<=years;i++) {
            maturedAmount+= ((ROI*maturedAmount)/100);
            System.out.println("Amount after Year"+i+": "+maturedAmount);
        }
        System.out.println("Total Profit: "+(maturedAmount-amount));
    }
    public void applyLoan(String loanType, float amount, int years) {
        float interest;
        float ROI = 10;
        interest = (amount*ROI*years)/100;
        System.out.println("Total interest: "+interest);
        System.out.println("Outstanding amount after interest: "+(amount+interest));
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return 0.0f;
    }
}