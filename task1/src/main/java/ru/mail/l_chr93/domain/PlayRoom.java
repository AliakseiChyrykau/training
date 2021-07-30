package ru.mail.l_chr93.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayRoom {
    private List<Toy> toyList;
    
    public PlayRoom(List<Toy> toyList, int maxTotalCostToys) {
    	this.toyList = new ArrayList<Toy>();
    	int index = 0;
    	int totalCost = 0;
    	while (toyList.size() > index + 1) {
    		if (totalCost + toyList.get(index).getPrice() <= maxTotalCostToys) {
    			totalCost += toyList.get(index).getPrice();
    			this.toyList.add(toyList.get(index));
    		}
			index++;
    	}
    }
    
    public void viewToyList() {
		for (Toy toy : toyList) {
			System.out.format("ID игрушки: %-3d название: %-7s размер: %-10s Минимальный возраст: %-3s цена: %-4d руб.%n", toy.getId(), toy.getName(),
					toy.getSize(), toy.getAgeGroup(), toy.getPrice());
		}
	}
    
    private void viewToyList(List<Toy> list) {
		for (Toy toy : list) {
			System.out.format("ID игрушки: %-3d название: %-7s размер: %-10s Минимальный возраст: %-3s цена: %-4d руб.%n", toy.getId(), toy.getName(),
					toy.getSize(), toy.getAgeGroup(), toy.getPrice());
		}
	}
    
    public void filterByName(String name) {
    	List<Toy> filterToyList = toyList.stream().filter(toy -> toy.getName().equals(name)).toList();
    	viewToyList(filterToyList);
    }
}
