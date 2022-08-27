/* menu.java */
import java.util.Scanner;

public class menu {
    int selectedOption;
    banking_account b = new banking_account();

    public void showMenu(){
        System.out.println("Please select an option below: ");
        System.out.println("1 - Depositing money");
        System.out.println("2 - Withdrawing money");
        System.out.println("3 - View balance");
        System.out.println("...or press any other key to exit.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Make your choice: ");
        selectedOption = scanner.nextInt();
        switch(selectedOption){
            case 1:
                System.out.println("Please enter the amount to deposit: ");
                deposit d = new deposit();
                int deposit_amount = d.userInput();
                b.add(deposit_amount);
                showMenu();
                break;
            case 2:
                System.out.println("Please enter the amount to withdraw: ");
                int withdraw_amount = scanner.nextInt();
                b.withdraw(withdraw_amount);
                showMenu();
                break;
            case 3:
                System.out.println("Your balance is: " + b.getBalance() + " Rubles.");
                showMenu();
                break;
            default:
                System.out.println("Exiting the bank account manager. Goodbye.");
                System.exit(0);
                break;
        }
    }
}
