package ru.mail.L_chr93.logic.findPalindrome;

import java.util.List;

import ru.mail.L_chr93.domain.Sentence;
import ru.mail.L_chr93.domain.Symbol;
import ru.mail.L_chr93.domain.TextElement;

public class MaxPalindromeSearcher implements PalindromeSearcher {
    Sentence maxPalindrome = new Sentence(" ");

    @Override
    public Sentence findPalindrome(TextElement text) {
        Sentence tempPalindrome = null;
        List<Symbol> symbolList = text.getSymbols();
        maxPalindrome = new Sentence();

        for (int centerIndex = 0; centerIndex < symbolList.size() - 1; centerIndex++) {

            if (symbolList.get(centerIndex).equals(symbolList.get(centerIndex + 1))) {
                if (centerIndex != 0 && symbolList.get(centerIndex - 1).equals(symbolList.get(centerIndex + 1))) {
                    tempPalindrome = findNotEvenPalindrom(centerIndex, symbolList);
                } else {
                    tempPalindrome = findEvenPalindrom(centerIndex, symbolList);
                }
            } else {
                tempPalindrome = findNotEvenPalindrom(centerIndex, symbolList);
            }

            if (isMax(tempPalindrome)) {
                maxPalindrome = tempPalindrome;
            }

        }
        return maxPalindrome;
    }

    private boolean isMax(Sentence palindrome) {
        return maxPalindrome.countLetter() < palindrome.countLetter();
    }

    public Sentence findEvenPalindrom(int centerIndex, List<Symbol> symbolList) {
        return findPalindrom(centerIndex, centerIndex + 1, symbolList);
    }

    public Sentence findNotEvenPalindrom(int centerIndex, List<Symbol> symbolList) {
        return findPalindrom(centerIndex, centerIndex, symbolList);
    }

    public Sentence findPalindrom(int leftIndex, int rightIndex, List<Symbol> symbolList) {
        while (leftIndex > 0 && rightIndex < symbolList.size() - 1) {
            while (leftIndex > 0 && !symbolList.get(leftIndex - 1).isLetterOrDigit()) {
                leftIndex--;
            }

            while (rightIndex < symbolList.size() - 1 && !symbolList.get(rightIndex + 1).isLetterOrDigit()) {
                rightIndex++;
            }

            if (leftIndex > 0 && rightIndex < symbolList.size() - 1) {
                if (!symbolList.get(leftIndex - 1).equals(symbolList.get(rightIndex + 1))) {
                    while (!symbolList.get(leftIndex).isLetterOrDigit() && leftIndex < rightIndex - 1) {
                        leftIndex++;
                    }

                    while (!symbolList.get(rightIndex).isLetterOrDigit() && leftIndex + 1 < rightIndex) {
                        rightIndex--;
                    }

                    return new Sentence(symbolList.subList(leftIndex, rightIndex + 1));
                }
                leftIndex--;
                rightIndex++;
            }
        }
        
        while (!symbolList.get(leftIndex).isLetterOrDigit() && leftIndex < rightIndex - 1) {
            leftIndex++;
        }

        while (!symbolList.get(rightIndex).isLetterOrDigit() && leftIndex + 1 < rightIndex) {
            rightIndex--;
        }

        return new Sentence(symbolList.subList(leftIndex, rightIndex + 1));
    }
}