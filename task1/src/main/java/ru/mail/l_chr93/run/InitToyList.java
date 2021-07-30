package ru.mail.l_chr93.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.mail.l_chr93.domain.*;
import ru.mail.l_chr93.domain.Ball;
import ru.mail.l_chr93.domain.ageGroup.*;
import ru.mail.l_chr93.domain.size.*;

public class InitToyList {
	private List<Toy> toyList = new ArrayList<>();
	private static Map<String, AgeGroup> ageGroupMap = new HashMap<String, AgeGroup>();
	private static Map<String, Size> sizeMap = new HashMap<String, Size>();

	{
		ageGroupMap.put("ForBabies", new ForBabies());
		ageGroupMap.put("ForChildren", new ForChildren());
		ageGroupMap.put("ForTeenagers", new ForTeenagers());

		sizeMap.put("Small", new Small());
		sizeMap.put("Average", new Average());
		sizeMap.put("Big", new Big());
	}

	public InitToyList() {
		InitToyList();
	}

	private void InitToyList() {
		this.toyList.add(new Ball(25, ageGroupMap.get("ForBabies"), sizeMap.get("Big")));
		this.toyList.add(new Car(123, ageGroupMap.get("ForTeenagers"), sizeMap.get("Average")));
		this.toyList.add(new Clack(33, ageGroupMap.get("ForChildren"), sizeMap.get("Small")));
		this.toyList.add(new Doll(51, ageGroupMap.get("ForBabies"), sizeMap.get("Average")));
		this.toyList.add(new Clack(99, ageGroupMap.get("ForChildren"), sizeMap.get("Big")));
		this.toyList.add(new Ball(101, ageGroupMap.get("ForTeenagers"), sizeMap.get("Average")));
		this.toyList.add(new Doll(205, ageGroupMap.get("ForBabies"), sizeMap.get("Average")));
		this.toyList.add(new Car(35, ageGroupMap.get("ForChildren"), sizeMap.get("Small")));
		this.toyList.add(new Doll(67, ageGroupMap.get("ForTeenagers"), sizeMap.get("Average")));
		this.toyList.add(new Ball(1, ageGroupMap.get("ForBabies"), sizeMap.get("Big")));
		this.toyList.add(new Clack(15, ageGroupMap.get("ForChildren"), sizeMap.get("Average")));
		this.toyList.add(new Clack(33, ageGroupMap.get("ForTeenagers"), sizeMap.get("Average")));
		this.toyList.add(new Car(109, ageGroupMap.get("ForBabies"), sizeMap.get("Average")));
		this.toyList.add(new Doll(37, ageGroupMap.get("ForChildren"), sizeMap.get("Small")));
		this.toyList.add(new Ball(42, ageGroupMap.get("ForTeenagers"), sizeMap.get("Average")));
		this.toyList.add(new Doll(53, ageGroupMap.get("ForBabies"), sizeMap.get("Big")));
	}

	public List<Toy> getListToy() {
		return toyList;
	}
}
