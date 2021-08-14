package ru.mail.L_chr93.logic.findPalindrome;

import ru.mail.L_chr93.domain.Sentence;
import ru.mail.L_chr93.domain.TextElement;

public class Palindrome {
    private PalindromeSearcher palindromeSearcher;

    public Palindrome(PalindromeSearcher palindromeSearcher) {
        this.palindromeSearcher = palindromeSearcher;
    }

   public PalindromeSearcher getPalindromeSearcher() {
        return palindromeSearcher;
    }

    public void setPalindromeSearcher(PalindromeSearcher palindromeSearcher) {
        this.palindromeSearcher = palindromeSearcher;
    }
    
    public Sentence findPalindrome(TextElement text) {
       return palindromeSearcher.findPalindrome(text);
    }
}
