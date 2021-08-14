package ru.mail.L_chr93.domain;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextElement {
    private List<TextElement> textElmentList;

    public Sentence() {
        textElmentList = new ArrayList<>();
    }

    public Sentence(String sentense) {
        textElmentList = new ArrayList<>();
        char[] charList = sentense.toCharArray();

        for (int i = 0; i < charList.length; i++) {
            Symbol symb = new Symbol(charList[i]);
            
            if (symb.isLetterOrDigit()) {
                Word word = new Word();
                
                while (symb.isLetterOrDigit()) {
                    word.addElement(symb);
                    i++;
                    symb = new Symbol(charList[i]);
                }
                
                textElmentList.add(word);
                textElmentList.add(symb);
            } else {
                textElmentList.add(symb);
            }
            
        }
    }

    public Sentence(List<Symbol> symbolList) {
        textElmentList = new ArrayList<>();

        for (int i = 0; i < symbolList.size();) {
            Symbol symb = symbolList.get(i);
            
            if (symb.isLetterOrDigit()) {
                Word word = new Word();
                
                while (symb.isLetterOrDigit()) {
                    word.addElement(symb);
                    
                    if (++i >= symbolList.size()) {
                        break;
                    }
                    
                    symb = symbolList.get(i);
                }
                
                textElmentList.add(word);
            } else {
                i++;
                textElmentList.add(symb);
            }

        }
    }

    @Override
    public List<Symbol> getSymbols() {
        List<Symbol> symbolsList = new ArrayList<>();

        for (TextElement textElement : textElmentList) {
            List<Symbol> tempList = textElement.getSymbols();
            tempList.stream().forEach(e -> symbolsList.add(e));
        }

        return symbolsList;
    }

    @Override
    public void addElement(TextElement element) {
        textElmentList.add(element);

    }

    @Override
    public TextElement getElement(int id) {
        return textElmentList.get(id);
    }

    @Override
    public int getLength() {
        return textElmentList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        textElmentList.stream().forEach(e -> sb.append(e.toString()));
        return sb.toString();
    }

    public int countLetter() {
        return (int) getSymbols().stream().filter(e -> e.isLetterOrDigit()).count();
    }
}
