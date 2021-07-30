package ru.mail.l_chr93.logic.comparator;

import java.util.Comparator;

import ru.mail.l_chr93.domain.Toy;

public class SizeComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getSize().compareTo(o2.getSize());
	}

}
