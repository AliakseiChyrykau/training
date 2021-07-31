package ru.mail.l_chr93.logic.filter;

import ru.mail.l_chr93.domain.Toy;
import ru.mail.l_chr93.domain.ageGroup.*;

public class AgeGroupFilter implements Filter {

	private AgeGroup ageGroup;
	
	public AgeGroupFilter(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
	}
	
	@Override
	public boolean check(Toy toy) {
		return toy.getAgeGroup() == ageGroup.getMinAge();
	}

}
