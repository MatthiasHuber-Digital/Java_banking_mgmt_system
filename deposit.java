/* deposit.java */
import java.util.Scanner;

public class deposit {
    int amount = 0;
    
    public int userInput(){
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextInt();

        if (amount < 0) {
            invalid_transaction depositnegativeError = new invalid_transaction("Amount is smaller than 0. Invalid deposit amount.");
            System.out.println(depositnegativeError.getMessage());
            userInput();
        }
        return amount;
    }
}
