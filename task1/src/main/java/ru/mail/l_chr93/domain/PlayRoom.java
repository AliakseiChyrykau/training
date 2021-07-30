package ru.mail.l_chr93.domain;

import java.util.List;

public class PlayRoom {
    private List<Toy> toyList;
    
    public PlayRoom(List toyList) {
    	this.toyList = toyList;
    }
    
    public void viewToysList() {
		for (Toy toy : toyList) {
			System.out.format("ID игрушки %d, название: %s, размер: %s, %s, цена: %d руб.%n", toy.getId(), toy.getName(),
					toy.getSize(), toy.getAgeGroup(), toy.getPrice());
		}
	}
}
