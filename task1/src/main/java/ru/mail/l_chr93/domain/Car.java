package ru.mail.l_chr93.domain;

import ru.mail.l_chr93.domain.ageGroup.AgeGroup;
import ru.mail.l_chr93.domain.size.Size;

public class Car extends Toy{
	public Car(int price, AgeGroup ageGroupe, Size size) {
    	super("car", price, ageGroupe, size);
    }
}
