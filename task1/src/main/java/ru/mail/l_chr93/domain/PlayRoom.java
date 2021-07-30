package ru.mail.l_chr93.domain;

import java.util.List;

public class PlayRoom {
    private List<Toy> toyList;
    
    public PlayRoom(List toyList) {
    	this.toyList = toyList;
    }
    
    public void viewToyList() {
		for (Toy toy : toyList) {
			System.out.format("ID игрушки: %-3d название: %-7s размер: %-10s Минимальный возраст: %-3s цена: %-4d руб.%n", toy.getId(), toy.getName(),
					toy.getSize(), toy.getAgeGroup(), toy.getPrice());
		}
	}
}
