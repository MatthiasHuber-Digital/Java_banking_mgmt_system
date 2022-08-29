/*login.java */
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

class account_manager {
    //private int ac_number;
    //private String ac_pass;
    private int ac;
    private String pw;
    safe_credentials credential_package = new safe_credentials();
    
    public void register_account () throws InvalidKeySpecException, NoSuchAlgorithmException{

        Scanner scanner = new Scanner(System.in);
        Scanner string_scanner = new Scanner(System.in);
        System.out.println("REGISTRATION of bank account.");
        System.out.println("Enter bank account integer number: ");
        int ac_number;
        ac_number = scanner.nextInt();

        while (true){
            String temp_password = "a";
            String temp_confirmation_password = "b";

            System.out.println("Enter password: ");
            temp_password = string_scanner.nextLine();
            System.out.println("Repeat password: ");
            temp_confirmation_password = string_scanner.nextLine();

            if (temp_confirmation_password.equals(temp_password) ){
                credential_package.password_hashing(ac_number, temp_password);
                System.out.println("Password-match successful. Registration finished successfully.\n");
                break;
            }
            else {
                System.out.println("Your passwords don't match. Please try again.");
            }
        }

    }

    public void tryLogin(){
        Scanner scanner = new Scanner(System.in);
        Scanner string_scanner = new Scanner(System.in);
        System.out.println("Login to account number: ");
        ac = scanner.nextInt();
        System.out.println("Login with password: ");
        pw = string_scanner.nextLine();
    }

    public void verify() throws Exception {
        if (credential_package.validatePassword(pw)) {
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
