package ru.mail.L_chr93.domain;

public enum Scene {
    ASSEMBLY_HALL("актовый зал"), OUTDOOR_PLAYGROUND("уличная площадка"), TV_STUDIO("телестудия");
    
    private String scene;
    
    Scene(String scene) {
        this.scene =scene;
    }
    
    public String getScene() {
        return scene;
    }
}
