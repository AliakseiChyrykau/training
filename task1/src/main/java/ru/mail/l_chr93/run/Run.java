package ru.mail.l_chr93.run;

import java.util.List;

import ru.mail.l_chr93.domain.PlayRoom;
import ru.mail.l_chr93.domain.Toy;
import ru.mail.l_chr93.domain.size.*;
import ru.mail.l_chr93.logic.filter.*;

public class Run {
	//private static boolean exitFlag = false;
	
	public static void main(String[] args) {
		InitToyList initToyList = new InitToyList();
		List<Toy> toyList = initToyList.getListToy();
		PlayRoom pr = new PlayRoom(toyList, 500);
		
		System.out.println("Список игрушек");
        pr.viewToyList();
		
        System.out.println("Cортировка игрушек по цене" );
		pr.sortToyList(pr.PRICE_COMPORATOR);
		
		System.out.println("Поиск больших игрушек");
		pr.filterList(new SizeFilter(PlayRoom.sizeMap.get("Big")));
	}

}
