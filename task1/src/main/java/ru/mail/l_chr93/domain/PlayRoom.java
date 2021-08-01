package ru.mail.l_chr93.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mail.l_chr93.domain.ageGroup.AgeGroup;
import ru.mail.l_chr93.domain.ageGroup.ForBabies;
import ru.mail.l_chr93.domain.ageGroup.ForChildren;
import ru.mail.l_chr93.domain.ageGroup.ForTeenagers;
import ru.mail.l_chr93.domain.size.Average;
import ru.mail.l_chr93.domain.size.Big;
import ru.mail.l_chr93.domain.size.Size;
import ru.mail.l_chr93.domain.size.Small;
import ru.mail.l_chr93.logic.comparator.*;
import ru.mail.l_chr93.logic.filter.Filter; 

public class PlayRoom {
	
	public static final Comparator<Toy> NAME_COMPARATOR = new NameComparator();
	public static final Comparator<Toy> SIZE_COMPARATOR = new SizeComparator();
	public static final Comparator<Toy> AGE_GROUP_COMPARATOR = new AgeGroupComparator();
	public static final Comparator<Toy> PRICE_COMPORATOR = new PriceComparator();
	public static final Comparator<Toy> NAME_AND_PRICE_COMPORATOR = NAME_COMPARATOR.thenComparing(PRICE_COMPORATOR);
	
	private List<Toy> toyList;
	public static final Map<String, AgeGroup> ageGroupMap = new HashMap<String, AgeGroup>();
	public static final Map<String, Size> sizeMap = new HashMap<String, Size>();

	static {
		ageGroupMap.put("ForBabies", new ForBabies());
		ageGroupMap.put("ForChildren", new ForChildren());
		ageGroupMap.put("ForTeenagers", new ForTeenagers());

		sizeMap.put("Small", new Small());
		sizeMap.put("Average", new Average());
		sizeMap.put("Big", new Big());
	}

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
		toyList.stream().forEach(toy -> System.out.print(toy.toString()));
	}

	private void viewToyList(List<Toy> list) {
		list.stream().forEach(toy -> System.out.print(toy.toString()));
	}

	public void filterList(Filter filter) {
		List<Toy> filterToyList = toyList.stream().filter(toy -> filter.check(toy)).toList();
		viewToyList(filterToyList);
	}
	
	public void sortToyList(Comparator<Toy> comparator) {
		List<Toy> sortList = new ArrayList<Toy>(toyList);
		sortList.sort(comparator);
		viewToyList(sortList);
	}
}
