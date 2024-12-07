package com.exemplu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masini")
public class Masina {
    @Id
    @Column(name = "nr_inmatriculare", nullable = false)
    private String nrInmatriculare;
    private String marca,culoare;
    @Column(name = "an_fabricatie", nullable = false)
    private int anFabricatie;
    @Column(name = "nr_kilometrii", nullable = false)
    private int nrKilometrii;

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public Masina(String nrInmatriculare, String marca, int anFabricatie, String culoare, int nrKilometrii) {
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.culoare = culoare;
        this.anFabricatie = anFabricatie;
        this.nrKilometrii = nrKilometrii;
    }

    public Masina() {}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getNrKilometrii() {
        return nrKilometrii;
    }

    public void setNrKilometrii(int nrKilometrii) {
        this.nrKilometrii = nrKilometrii;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nrInmatriculare='" + nrInmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", culoare='" + culoare + '\'' +
                ", anFabricatie=" + anFabricatie +
                ", nrKilometrii=" + nrKilometrii +
                '}';
    }
}
