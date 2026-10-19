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
public class MessageTest {
      
    Message message = new Message();

    // Test 1 - Valid recipient
    @Test
    public void testCheckRecipientCellValid() {
        String result = message.checkRecipientCell("+27718693002");
        assertEquals("Cell phone number successfully captured.", result);
    }

    // Test 2 - Invalid recipient no +27
    @Test
    public void testCheckRecipientCellInvalid() {
        String result = message.checkRecipientCell("08575975889");
        assertTrue(result.contains("incorrectly formatted"));
    }

    // Test 3 - Invalid recipient too long
    @Test
    public void testCheckRecipientCellTooLong() {
        String result = message.checkRecipientCell("+27718693002123");
        assertTrue(result.contains("incorrectly formatted"));
    }

    // Test 4 - Message length valid
    @Test
    public void testCheckMessageLengthValid() {
        String result = message.checkMessageLength("Hi Mike, can you please call me");
        assertEquals("Message ready to send.", result);
    }

    // Test 5 - Message length invalid - more than 250
    @Test
    public void testCheckMessageLengthInvalid() {
        String longMsg = "a".repeat(260);
        String result = message.checkMessageLength(longMsg);
        assertTrue(result.contains("exceeds 250"));
    }

    // Test 6 - Message ID valid 10 chars
    @Test
    public void testCheckMessageIDValid() {
        assertTrue(message.checkMessageID("1234567890"));
    }

    // Test 7 - Message ID invalid more than 10
    @Test
    public void testCheckMessageIDInvalid() {
        assertFalse(message.checkMessageID("1234567890123"));
    }

    // Test 8 - Generate ID length is 10
    @Test
    public void testGenerateMessageIDLength() {
        String id = message.generateMessageID();
        assertEquals(10, id.length());
    }

    // Test 9 - Create hash not null
    @Test
    public void testCreateMessageHash() {
        String hash = message.createMessageHash("0012345678", 0, "Hi Mike");
        assertNotNull(hash);
        assertTrue(hash.contains(":0:"));
    }

    // Test 10 - Send message options
    @Test
    public void testSendMessage() {
        assertEquals("Message successfully sent.", message.sendMessage("1"));
        assertEquals("Message successfully stored.", message.sendMessage("2"));
        assertEquals("Message disregarded.", message.sendMessage("3"));
    }
}