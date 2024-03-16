package com.nurlandaryn.springMVC.entity;

public class Hero {
    private int id;
    private String name;
    private String rang;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getRang() {
        return rang;
    }

    public Hero(){}

    public Hero(int id, String name, String rang) {
        this.id = id;
        this.name = name;
        this.rang = rang;
    }
}
