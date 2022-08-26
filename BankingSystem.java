

class Bank {
    static int balance = 1000;

    static synchronized void withdrawal (String name, int withdraw_amount) {
            if (balance >= withdraw_amount) {
                System.out.println("\nName: " + name + ", withdrawing amount: " + withdraw_amount);
                balance -= withdraw_amount;
                System.out.println("Updated balance: " + balance);

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("\nName: " + name + ", CANNOT withdraw amount: " + withdraw_amount);
                System.out.println("Your balance does not cover a withdraw amount that high. Please adjust your query accordingly.");

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }


    static synchronized void deposit (String name, int deposit_amount) {
        System.out.println("\nName: " + name + ", depositing amount: " + deposit_amount);
        balance += deposit_amount;
        System.out.println("Updated balance: " + balance);

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadWithdrawal extends Thread {
    Bank object;
    String name;
    int withdraw_amount;

    ThreadWithdrawal (Bank o, String n, int am) {
        this.object = o;
        this.name = n;
        this.withdraw_amount = am;
    }

    public void run () {
        object.withdrawal(name, withdraw_amount);
    }
}

class ThreadDeposit extends Thread {
    Bank object;
    String name;
    int deposit_amount;

    ThreadDeposit (Bank o, String n, int am) {
        this.object = o;
        this.name = n;
        this.deposit_amount = am;
    }

    public void run () {
        object.deposit(name, deposit_amount);
    }
}


public class BankingSystem {
    public static void main (String[] args) {
        Bank MyBank = new Bank();

        System.out.println("\n\n+++ Banking System Example +++\n");

        ThreadWithdrawal t_draw_1 = new ThreadWithdrawal(MyBank, "Thomas", 50);

        ThreadWithdrawal t_draw_2 = new ThreadWithdrawal(MyBank, "Andreas", 1000);

        ThreadDeposit t_depo_1 = new ThreadDeposit(MyBank, "Thomas", 3000);

        ThreadWithdrawal t_draw_3 = new ThreadWithdrawal(MyBank, "Andreas", 5000);


        t_draw_1.start();
        t_draw_2.start();
        t_depo_1.start();
        t_draw_3.start();
    }
}
