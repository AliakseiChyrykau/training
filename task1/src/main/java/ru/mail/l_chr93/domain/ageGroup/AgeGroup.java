package ru.mail.l_chr93.domain.ageGroup;

public abstract class AgeGroup {
	private final int minAge;

	public AgeGroup(int minAge) {
		this.minAge = minAge;
	}

	public int getMinAge() {
		return this.minAge;
	}

	@Override
	public String toString() {
		return String.format("%d+", getMinAge());
	} 
}
