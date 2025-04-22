/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package whatsapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aspir
 */
public class WhatsappTest {
    

    // Username: must contain "_" and ≤ 5 characters
    public boolean checkUserName(String Username) {
        return Username.contains("_") && Username.length() <= 5;
    }

    // Password: min 8 chars, at least 1 capital, 1 number, 1 special char
    public boolean checkPasswordComplexity(String Password) {
        return Password.length() >= 8 &&
               Password.matches(".*[A-Z].*") &&
               Password.matches(".*\\d.*") &&
               Password.matches(".*[!@#$%^&*()_+\\-=\\{};':\"\\\\|,.<>\\/?].*");
    }

    // Cell number: must start with +27 and have 12 digits total
    public boolean checkCellPhoneNumber(String Phonenumber) {
        return Phonenumber.matches("\\+27\\d{9}");
    }

    // Simulated login logic
    public boolean login(String Username, String Password) {
        return checkUserName(Username) && checkPasswordComplexity(Password);
    }

    @Test
    public void testValidUsername() {
        assertTrue(checkUserName("kyl_1"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(checkPasswordComplexity("password"));
    }

    @Test
    public void testValidCellNumber() {
        assertTrue(checkCellPhoneNumber("+27839698976"));
    }

    @Test
    public void testInvalidCellNumber() {
        assertFalse(checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(login("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        assertFalse(login("kyle!!!!!!!", "password"));
    }

    public WhatsappTest() {
    }

    @Test
    public void testSomeMethod() {
    }
    
}