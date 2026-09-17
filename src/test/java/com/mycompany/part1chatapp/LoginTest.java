/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part1chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    
        @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testLoginSuccessful() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("kyl_1", "wrongpass"));
    }

    // === 6 NEW MESSAGE TESTS TO MAKE IT 14 ===
    
    @Test
    public void testRegisterUserSuccessful() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Cell number successfully captured.", login.registerUser());
    }

    @Test
    public void testRegisterUserUsernameErrorMessage() {
        Login login = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", login.registerUser());
    }

    @Test
    public void testRegisterUserPasswordErrorMessage() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", login.registerUser());
    }

    @Test
    public void testRegisterUserCellErrorMessage() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell number incorrectly formatted or does not contain an international code; please correct the number and try again.", login.registerUser());
    }

    @Test
    public void testReturnLoginStatusSuccessful() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Welcome Kyle Smith, it is great to see you again.", login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testReturnLoginStatusFailed() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus("kyl_1", "wrongpass"));
    }
}
    

