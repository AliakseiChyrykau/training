package ru.mail.l_chr93.domain.size;

public abstract class Size {
	private final String size;

	public Size(String size) {
		this.size = size;
	}

	public String getSize() {
		return this.size;
	}
	
	public String toString() {
		return size;
	}
}
