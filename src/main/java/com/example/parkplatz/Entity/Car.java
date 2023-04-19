package com.example.parkplatz.Entity;

public class Car {

    private String id;
    private String name;
    private String modell;

    public Car() {
    }

    public Car(String id, String name, String modell) {
        this.id = id;
        this.name = name;
        this.modell = modell;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", modell='" + modell + '\'' +
                '}';
    }
}
