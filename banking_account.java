/* banking_account.java */
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class banking_account {
    int amount = 5000;
    public void initiate(){
        account_manager a_m = new account_manager();
        try{
            a_m.register_account();
        }
        catch(Exception register){
            System.out.println("Error during the registration process. Aborting.");
            System.exit(0);
        }
        
        while (true){
            try{
                a_m.tryLogin();
                a_m.verify();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Error logging in: try again please.");
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
