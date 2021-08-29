package ru.mail.L_chr93.domain;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DanceGroup implements Dancers {
    
    private String name;
    private String name_head;
    private Date year_formation;

    @Override
    public String getInfo() {
        SimpleDateFormat fd = new SimpleDateFormat("dd MMMM yyyy", new Locale("ru", "RU"));
        return String.format("Название коллектива: %s, имя руководителя: %s, дата формирования коллектива: %s", name, name_head, fd.format(year_formation));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_head() {
        return name_head;
    }

    public void setName_head(String name_head) {
        this.name_head = name_head;
    }

    public Date getYear_formation() {
        return year_formation;
    }

    public void setYear_formation(Date year_formation) {
        this.year_formation = year_formation;
    }

    @Override
    public String toString() {
        return getInfo();
    }
    
}
