package ru.mail.L_chr93.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Concert {

    private List<DanceNumber> danceNumberList = null;
    
    public Concert() {
        danceNumberList = new ArrayList<>();
    }
    
    public void addNumber(DanceNumber danceNumber) {
        danceNumberList.add(danceNumber);
    }
    
    public boolean removeNumber(DanceNumber danceNumber) {
        return danceNumberList.remove(danceNumber);
    }
    
    public void viewNumbers() {
        for (DanceNumber danceNumber : danceNumberList) {
            System.out.println(danceNumber);
        }
    }
    
    public void sort(Comparator<DanceNumber> comparator) {
        danceNumberList.sort((Comparator<DanceNumber>) comparator);
    }
}
