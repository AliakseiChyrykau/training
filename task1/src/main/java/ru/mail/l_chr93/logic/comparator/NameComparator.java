package ru.mail.l_chr93.logic.comparator;

import java.util.Comparator;

import ru.mail.l_chr93.domain.Toy;

public class NameComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
