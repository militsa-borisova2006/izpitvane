package com.company;

public class Apartment {
    private String city;
    private int rooms;
    private int kvadratura;
    private int cena;
    private int telefon;

    public Apartment(String city, int rooms, int kvadratura, int cena, int telefon) {
        this.city = city;
        this.rooms = rooms;
        this.kvadratura = kvadratura;
        this.cena = cena;
        this.telefon = telefon;
    }

    public Apartment() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}
