package ru.mail.L_chr93;

import java.util.ResourceBundle;

import ru.mail.L_chr93.domain.Text;
import ru.mail.L_chr93.logic.findPalindrome.MaxPalindromeSearcher;
import ru.mail.L_chr93.logic.findPalindrome.Palindrome;
import ru.mail.L_chr93.logic.textReader.TextReader;
import ru.mail.L_chr93.logic.textReader.TxtTextReader;

public class Main {
    public static void main(String... args) {
        ResourceBundle rb = ResourceBundle.getBundle("settings");
        String filePath = Main.class.getResource(rb.getString("filePath")).getPath();
        TextReader txR = new TxtTextReader(filePath);

        Text text = new Text();
        while (txR.hasNext()) {
            text.addElement(txR.readSentence());
        }

        Palindrome palindrome = new Palindrome(new MaxPalindromeSearcher());
        System.out.println(palindrome.findPalindrome(text));
    }
}