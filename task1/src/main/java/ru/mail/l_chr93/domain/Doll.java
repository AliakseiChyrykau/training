package ru.mail.l_chr93.domain;

import ru.mail.l_chr93.domain.ageGroup.AgeGroup;
import ru.mail.l_chr93.domain.size.Size;

public class Doll extends Toy{
	public Doll(int price, AgeGroup ageGroupe, Size size) {
    	super("doll", price, ageGroupe, size);
    }
}
