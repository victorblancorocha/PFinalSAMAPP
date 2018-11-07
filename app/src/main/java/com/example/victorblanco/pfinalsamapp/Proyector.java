package com.example.victorblanco.pfinalsamapp;

public class Proyector {
    private int id;
    private String marca;
    private int modelo;
    private String disponible;

    public Proyector(int id, String marca, int modelo, String disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }
}

