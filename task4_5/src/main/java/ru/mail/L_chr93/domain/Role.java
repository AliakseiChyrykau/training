package ru.mail.L_chr93.domain;

public enum Role {
    ADMIN("role.admin", "/WEB-INF/jsp/menuAdmin.jsp"), MANAGER("role.manager", "/WEB-INF/jsp/menuManager.jsp"), DEVELOPER("role.developer", "/WEB-INF/jsp/menuDeveloper.jsp"),
        CUSTOMER("role.customer", "/WEB-INF/jsp/menuCustomer.jsp");

    private String name;
    private String url;
    
    Role(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Long getId() {
        return Long.valueOf(ordinal() + 1);
    }

    public String getName() {
        return name;
    }
    
    public String getUrl() {
        return url;
    }
}
