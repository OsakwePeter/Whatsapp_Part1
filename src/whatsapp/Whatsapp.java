/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package whatsapp;
import java.util.Scanner;

public class Whatsapp {
private static String Firstname;
private static String Lastname;
private static String Username;
private static String Password;
private static String Phonenumber;
private static String registeredUsername;
private static String registeredPassword;
private static boolean loginsuccessfully = false;
public static boolean checkUserName(String Username){
    if(Username.contains("_") && Username.length() <= 5){
        return true;
} 
    else {
        return false;
}
}

public static boolean checkPasswordComplexity(String Password){
    Scanner password = new Scanner(System.in);
    boolean hasSpecialCharacter = Password.matches(".*[A-Z].*");
    boolean hasNumber = Password.matches(".*\\d.*");
    boolean hasUpperCase = Password.matches(".*[^a-zA-Z0-9].*");
    
    if(Password.length() < 8){
        return false;
    }
    else{
        return hasSpecialCharacter && hasNumber && hasUpperCase;
    }

}
public static boolean checkCellPhoneNumber(String Phonenumber){
    boolean hasnumber = Phonenumber.matches("^\\+\\d{2,7}\\d{9}$");
    if(hasnumber){
        return true;
    }
    else{
        return false;
    }
}
//This storees the userinput    
public static String registerUser(String Username, String Password, String Phonenumber){
     if (!Username.matches("^[a-zA-Z0-9_]{5,15}$")) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!Password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(Phonenumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
}
        registeredUsername = Username;
        registeredPassword = Password;
        return "User registered succesfully.";
}

public static boolean loginUser(String Username, String Password){
    if(Username.equals(registeredUsername) && Password.equals(registeredPassword)){
        loginsuccessfully = true;
        return true;
    }
    else{
        loginsuccessfully = false;
        return false;
    }
}

public static String returnLoginStatus(){
if(loginsuccessfully){
            return "Welcome " + Firstname +""+ Lastname + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
}
public static void main(String[] args) {
    Scanner details = new Scanner(System.in);
    System.out.println("Enter your firstname");
    Firstname = details.nextLine();
    
    System.out.println("Enter your lastname");
    Lastname = details.nextLine();
    
    while(true){
    System.out.println("Enter your username");
    Username = details.nextLine();
    
        if(checkUserName(Username)){
        System.out.println("Username successfully captured.");
        break;
        }
    else{
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        }
    }
    while(true){
    System.out.println("Enter your password");
    Password = details.nextLine();
    
        if(checkPasswordComplexity(Password)){
        System.out.println("Password successfully captured.");
        break;
        }
    else{
        System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
    }
    }
    while(true){
    System.out.println("Enter your phone number");
    Phonenumber = details.nextLine();
    if(checkCellPhoneNumber(Phonenumber)){
        System.out.println("Cell phone number successfully added.");
        break;
    }
    else{
        System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
    }
        System.out.println(registerUser(Username, Password, Phonenumber));
    }

        boolean loggedin = false;

        // Login Attempt
        
        System.out.println("\n--- Login ---");
        while(!loggedin){
        System.out.println("Enter username to login: ");
        registeredUsername = details.nextLine();
        System.out.println("Enter password to login: ");
        registeredPassword = details.nextLine();
        loggedin = loginUser(Username, Password);
        if(loggedin){
            System.out.println(returnLoginStatus());
            break;
        }
        else{
            System.out.println("Username or password incorrect, please try again.");
        }
 
        
        }
        }

        

       
    }
