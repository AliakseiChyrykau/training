package ru.mail.l_chr93.domain;

import ru.mail.l_chr93.domain.ageGroup.*;
import ru.mail.l_chr93.domain.size.*;

public abstract class Toy {
    private static int counterID = 1;
    
    private String name;
    private int id;
    private int price;
    private AgeGroup ageGroup;
    private Size size;
    
    public Toy(String name, int price, AgeGroup ageGroup, Size size) {
    	id = counterID++;
    	this.name = name;
    	this.price = price;
    	this.ageGroup = ageGroup;
    	this.size = size;
    }

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public int getAgeGroup() {
		return ageGroup.getMinAge();
	}

	public String getSize() {
		return size.getSize();
	}

	@Override
	public String toString() {
		return String.format("ID игрушки: %-3d название: %-7s размер: %-9s Минимальный возраст: %-2s года/лет цена: %-3d руб.%n", 
				id, name, getSize(), getAgeGroup(), price);
	}
    
    
}
