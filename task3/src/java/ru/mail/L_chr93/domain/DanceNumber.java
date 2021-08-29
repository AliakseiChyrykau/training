package ru.mail.L_chr93.domain;

import java.util.List;

public class DanceNumber {

    private String id;
    private Type type = null;
    private Scene scene = null;
    private NumberOfDancers numberOfDancers = null;
    private Music music = null;
    private List<Dancers> listDancer = null;
    private int number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type.getType();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getScene() {
        return scene.getScene();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getNumberOfDancers() {
        return numberOfDancers.getNnumberOfDancers();
    }

    public void setNumberOfDancers(NumberOfDancers numberOfDancers) {
        this.numberOfDancers = numberOfDancers;
    }

    public String getMusic() {
        return music.getMusic();
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public List<Dancers> getListDancer() {
        return listDancer;
    }

    public void setListDancer(List<Dancers> listDancer) {
        this.listDancer = listDancer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DanceNumber [id=" + id + ", type=" + getType() + ", scene=" + getScene() + ", numberOfDancers="
                + getNumberOfDancers() + ", music=" + getMusic() + ", listDancer=" + listDancer + ", number=" + number
                + "]";
    }

}
