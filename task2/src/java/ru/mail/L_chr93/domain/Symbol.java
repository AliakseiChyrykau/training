package ru.mail.L_chr93.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Symbol implements TextElement {

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Symbol other = (Symbol) obj;
        return Character.toLowerCase(symbol) == Character.toLowerCase(other.symbol);
    }

    @Override
    public List<Symbol> getSymbols() {
        List<Symbol> tempList = new ArrayList<>();
        tempList.add(this);
        return tempList;
    }

    @Override
    public void addElement(TextElement element) {
    }

    @Override
    public TextElement getElement(int id) {
        return this;
    }

    @Override
    public int getLength() {
        return 1;
    }

    public Character getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }

    public boolean isLetterOrDigit() {
        return Character.isLetterOrDigit(symbol);
    }
}
