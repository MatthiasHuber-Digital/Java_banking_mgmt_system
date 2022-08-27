/* bankingapp.java */
public class bankingapp{
    public static void main (String[] args) throws Exception {
        System.out.println("Welcome to my bank!");
        banking_account b = new banking_account();
        b.initiate();
    }
}