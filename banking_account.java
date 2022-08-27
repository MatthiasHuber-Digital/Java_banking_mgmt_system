/* banking_account.java */
import java.util.Scanner;

public class banking_account {
    int amount = 5000;
    public void initiate(){
        login l1 = new login();
        try{
            l1.acceptInput();
            l1.verify();
        }
        catch(Exception e)
        {
            try{
                l1.acceptInput();
                l1.verify();
            }
            catch(Exception f){
                
            }
        }
    }

    public int getBalance(){
        return amount;
    }
    
    public void add(int add_amount){
        amount += add_amount;
        System.out.println("Amount deposited successfully.");
        System.out.println("Updated balance: " + amount + "\n");
    }
    
    public void withdraw(int withdraw_amount){
        if (amount < withdraw_amount){
            invalid_transaction invalidWithdrawal = new invalid_transaction("Withdrawal amount exceeds current balance.\n");
            System.out.println(invalidWithdrawal.getMessage());
        }
        else{
            amount -= withdraw_amount;
            System.out.println("Please collect your " + withdraw_amount + " Rubles.");
            System.out.println("Updated balance: " + amount + "\n");
        }
    }
}
