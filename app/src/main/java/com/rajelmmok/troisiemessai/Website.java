package com.rajelmmok.troisiemessai;

public class Website {

    private String name;
    private String domain;
    private int icon;
    private String description;

    public Website() {
    }

    public Website(String name, String domain, int icon, String description) {
        this.name = name;
        this.domain = domain;
        this.icon = icon;
        this.description = description;
    }

    public String getName() { return name; }

    public String getDomain() {
        return domain;
    }

    public int getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }
}
