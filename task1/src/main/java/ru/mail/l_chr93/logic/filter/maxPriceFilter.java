package ru.mail.l_chr93.logic.filter;

import ru.mail.l_chr93.domain.Toy;

public class maxPriceFilter implements Filter {

	private int maxPrice;
	
	public maxPriceFilter(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	@Override
	public boolean check(Toy toy) {
		return toy.getPrice() <= maxPrice;
	}

}
