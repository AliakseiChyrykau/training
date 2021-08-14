package ru.mail.L_chr93.domain;

import java.util.List;

public interface TextElement {
	List<Symbol> getSymbols();
	void addElement(TextElement element);
	TextElement getElement(int id);
	int getLength();
}
