package ru.mail.L_chr93.comparator;

import java.util.Comparator;

import ru.mail.L_chr93.domain.DanceNumber;

public class TypeComporator implements Comparator<DanceNumber>{

    @Override
    public int compare(DanceNumber o1, DanceNumber o2) {
        return o1.getType().compareTo(o2.getType());
    }

}
