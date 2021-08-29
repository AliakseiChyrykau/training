package ru.mail.L_chr93.domain;

public enum Music {
    SOUNDTRACK("фонограмма"), LIVE_MUSIC("живая музыка"); 
    
    private String music;
    
    Music(String music) {
        this.music = music;
    }
    
    public String getMusic() {
        return music;
    }
}
