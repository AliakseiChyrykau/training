package ru.mail.L_chr93.domain;

public class Dancer implements Dancers {

    private String name;
    private int age;
    private int how_many_years;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHow_many_years() {
        return how_many_years;
    }

    public void setHow_many_years(int how_many_years) {
        this.how_many_years = how_many_years;
    }

    @Override
    public String getInfo() {
        return String.format("Имя танцора: %s, Возраст: %s, Сколько лет занимается: %s", name, age, how_many_years);
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
