/* invalid_transaction.java */

public class invalid_transaction extends Exception{
    String errorMessage;
    
    public invalid_transaction(String message){
        errorMessage = message;
    }
    public String getMessage(){
        return errorMessage;
    }
}
