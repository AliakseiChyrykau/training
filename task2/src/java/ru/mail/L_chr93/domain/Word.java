package ru.mail.L_chr93.domain;

import java.util.ArrayList;
import java.util.List;

public class Word implements TextElement {
    List<Symbol> symbolList;

    public Word() {
        symbolList = new ArrayList<>();
    }

    @Override
    public List<Symbol> getSymbols() {
        return symbolList;
    }

    @Override
    public void addElement(TextElement element) {
        symbolList.add((Symbol) element);

    }

    @Override
    public TextElement getElement(int id) {
        return symbolList.get(id);
    }

    @Override
    public int getLength() {
        return symbolList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        symbolList.stream().forEach(e -> sb.append(e.toString()));
        return sb.toString();
    }
}
