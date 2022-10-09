public class BankAccount {
    private static int nextId=1;
    private static double interestRate=0.02;
    private int id;
    private double balance;


    public BankAccount(){
        this.id=nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest(int year){
        return balance*year*interestRate;
    }

    public static void setInterestRate(double interest){
        BankAccount.interestRate=interest;
    }

    public void deposit(double amount){
        balance+=amount;
    }
}
