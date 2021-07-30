package ru.mail.l_chr93.domain;

import ru.mail.l_chr93.domain.ageGroup.AgeGroup;
import ru.mail.l_chr93.domain.size.Size;

public class Ball extends Toy {
    public Ball(int price, AgeGroup ageGroupe, Size size) {
    	super("ball", price, ageGroupe, size);
    }
}
