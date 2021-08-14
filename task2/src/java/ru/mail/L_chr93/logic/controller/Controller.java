package ru.mail.L_chr93.logic.controller;

import java.util.ResourceBundle;
import java.util.Scanner;

import ru.mail.L_chr93.domain.Sentence;
import ru.mail.L_chr93.domain.Text;
import ru.mail.L_chr93.logic.findPalindrome.MaxPalindromeSearcher;
import ru.mail.L_chr93.logic.findPalindrome.Palindrome;
import ru.mail.L_chr93.logic.textReader.TextReader;
import ru.mail.L_chr93.logic.textReader.TxtTextReader;

public class Controller {

    public void findMaxPalindrome() {
        Sentence tempMaxPalindrome = new Sentence("");
        Sentence tempPalindrome = new Sentence("");
        ResourceBundle rb = ResourceBundle.getBundle("settings");
        String filePath = Controller.class.getResource(rb.getString("filePath")).getPath();
        TextReader txR = new TxtTextReader(filePath);
        Palindrome palindrome = new Palindrome(new MaxPalindromeSearcher());
        Text tempText = new Text();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите количиство предложений проверяемых за раз");
        int quantitySentence = scanner.nextInt();
        
        while (txR.hasNext()) {
            for (int i = 0; txR.hasNext() && i < quantitySentence; i++) {
                tempText.addElement(txR.readSentence());    
            }
            
           tempPalindrome = palindrome.findPalindrome(tempText);
            
            if (tempMaxPalindrome.countLetter() < tempPalindrome.countLetter()) {
               tempMaxPalindrome = palindrome.findPalindrome(tempText);
            }
            
            tempText = new Text();
        }

        System.out.println(tempMaxPalindrome);
    }
}