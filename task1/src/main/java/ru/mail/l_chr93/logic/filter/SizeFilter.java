package ru.mail.l_chr93.logic.filter;

import ru.mail.l_chr93.domain.Toy;
import ru.mail.l_chr93.domain.size.Size;

public class SizeFilter implements Filter {

	private Size size;
	
	public SizeFilter(Size size) {
		this.size = size;
	}
	
	@Override
	public boolean check(Toy toy) {
		return toy.getSize().equals(size.getSize());
	}

}
