package ru.mail.L_chr93.domain;

public enum Role {
    ADMIN("role.admin"), MANAGER("role.manager"), DEVELOPER("role.developer"), CUSTOMER("role.customer");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return Long.valueOf(ordinal() + 1);
    }

    public String getName() {
        return name;
    }
}
