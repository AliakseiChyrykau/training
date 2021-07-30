package ru.mail.l_chr93.logic.comparator;

import java.util.Comparator;

import ru.mail.l_chr93.domain.Toy;

public class PriceComparator implements Comparator<Toy> {

	@Override
	public int compare(Toy o1, Toy o2) {
		return o1.getPrice() - o2.getPrice();
	}

}
