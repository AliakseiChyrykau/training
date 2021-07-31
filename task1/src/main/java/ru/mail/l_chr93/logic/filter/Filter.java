package ru.mail.l_chr93.logic.filter;

import ru.mail.l_chr93.domain.Toy;

public interface Filter {
	public boolean check(Toy toy);
}
