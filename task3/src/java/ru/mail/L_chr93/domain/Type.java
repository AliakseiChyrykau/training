package ru.mail.L_chr93.domain;

public enum Type {
    BALLROOM("бальный"), NATIONAL("народный"), POP("эстрадный"), EASTERN("восточный");
    
    String type;
    
    Type(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
}
