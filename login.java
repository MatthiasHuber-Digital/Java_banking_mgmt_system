/*login.java */
import java.io.*;
import java.util.Scanner;

class login {
    int ac_number = 123456;
    int ac_pass = 41089494;
    int ac, pw;
    
    public void acceptInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter my-bank account number: ");
        ac = scanner.nextInt();
        
        System.out.println("Enter my-bank account password: ");
        pw = scanner.nextInt();
    }

    public void verify() throws Exception {
        if (ac == ac_number && pw == ac_pass) {
            System.out.println("Successfully logged into your account.");
            banking_account b = new banking_account();
            System.out.println("Your account balance is: " + b.getBalance()+ "Rubles.\n");

            menu m1 = new menu();
            m1.showMenu();
        }
        else {
            invalid_transaction loginfailed = new invalid_transaction("Incorrect login credentials.");
            System.out.println(loginfailed.getMessage());
            throw loginfailed;
        }
    }
}
