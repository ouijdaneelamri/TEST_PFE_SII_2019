package sii.maroc.Exception;

public class UnavailableDishException extends Exception{
    public void displayMessage() {
        System.out.println("out of stock");
    }
}
