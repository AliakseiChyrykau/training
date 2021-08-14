package ru.mail.L_chr93.logic.findPalindrome;

import ru.mail.L_chr93.domain.Sentence;
import ru.mail.L_chr93.domain.TextElement;

public interface PalindromeSearcher {
    Sentence findPalindrome(TextElement text);
}
