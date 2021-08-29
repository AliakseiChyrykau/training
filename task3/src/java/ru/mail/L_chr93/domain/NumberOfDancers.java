package ru.mail.L_chr93.domain;

public enum NumberOfDancers {
    MASS("массовый"), SOLO("сольный"), PAIRED("парный");
    
    private String numberOfDancers;
    
    private NumberOfDancers(String numberOfDancers) {
        this.numberOfDancers = numberOfDancers;
    }
    
    public String getNnumberOfDancers() {
        return numberOfDancers;
    }
}
