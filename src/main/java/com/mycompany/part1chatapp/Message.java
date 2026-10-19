/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1chatapp;
import java.util.Random;
/**
 *
 * @author Student
 */

public class Message {
   public String generateMessageID(){
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    public boolean checkMessageID(String id){
        return id.length() <= 10;
    }

    public String checkRecipientCell(String cell){
        if(cell!=null && cell.startsWith("+") && cell.length()>=10 && cell.length()<=13){
            String digits = cell.substring(1);
            if(digits.matches("\\d+")){
                return "Cell phone number successfully captured.";
            }
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }

    public String checkMessageLength(String message){
        if(message.length()<=250){
            return "Message ready to send.";
        } else {
            int excess = message.length()-250;
            return "Message exceeds 250 characters by " + excess;
        }
    }
    
    public String createMessageHash(String id, int num, String message){
        String[] words = message.split(" ");
        return (id.substring(0,2) + ":" + num + ":" + words[0] + words[words.length-1]).toUpperCase();
    }

    public String sendMessage(String option){
        if(option.equals("1")) return "Message successfully sent.";
        if(option.equals("2")) return "Message successfully stored.";
        return "Message disregarded.";
 
}
}