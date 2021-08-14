package ru.mail.L_chr93.domain;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextElement {
    private List<TextElement> sentenceList;

    public Text() {
        sentenceList = new ArrayList<>();
    }

    @Override
    public List<Symbol> getSymbols() {
        List<Symbol> symbolsList = new ArrayList<>();

        for (TextElement textElement : sentenceList) {
            List<Symbol> tempList = textElement.getSymbols();
            tempList.stream().forEach(e -> symbolsList.add(e));
        }

        return symbolsList;
    }

    @Override
    public void addElement(TextElement element) {
        sentenceList.add(element);
    }

    @Override
    public TextElement getElement(int id) {
        return sentenceList.get(id);
    }

    @Override
    public int getLength() {
        return sentenceList.size();
    }
}