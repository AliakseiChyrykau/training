package ru.mail.l_chr93.logic.comparator;

import java.util.Comparator;

import ru.mail.l_chr93.domain.Toy;

public class AgeGroupComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getAgeGroup() - o2.getAgeGroup();
	}

}
