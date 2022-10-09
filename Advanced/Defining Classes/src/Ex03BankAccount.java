import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Ex03BankAccount {
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);

    String input=scanner.nextLine();
    Map<Integer,BankAccount> members=new HashMap<>();
        BiFunction<BankAccount,String[],String> depositFunction=(b,arr)->{
            int amount=Integer.parseInt(arr[2]);
            b.deposit(amount);
            return "Deposit "+ amount+ " ID"+arr[1];
        };

        BiFunction<BankAccount,String[],String> getInterestFunction=(b,arr)->{
            int years=Integer.parseInt(arr[2]);
            double interest =b.getInterest(years);
            return String.format("%.2f",interest);
        };

    while (!input.equals("End")){
        String command=input.split(" ")[0];

        switch (command){
            case "Create":
                BankAccount account=new BankAccount();
                members.put(account.getId(),account);
                System.out.println("Account ID"+account.getId()+" created");
                break;
            case "Deposit":
                System.out.println(executeBankAccount(input,members,depositFunction));
                break;
            case "SetInterest":
                double interestRate=Double.parseDouble(input.split(" ")[1]);
                BankAccount.setInterestRate(interestRate);
                break;
            case "GetInterest":
                System.out.println(executeBankAccount(input,members,getInterestFunction));
                break;
        }

        input=scanner.nextLine();
    }

    }

    private static String  executeBankAccount(String input, Map<Integer, BankAccount> members,
                                               BiFunction<BankAccount, String[], String> function) {
        int id=Integer.parseInt(input.split(" ")[1]);
        BankAccount bankAccount=members.get(id);

        if(bankAccount==null){
            return "Account does not exist";
        }
        return function.apply(bankAccount,input.split(" "));
    }
}
