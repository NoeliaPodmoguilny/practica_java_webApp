package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMascota;
    private String nombreMascota;
    private String color;
    private String raza;
    private String alergico;
    private String atencionEspe;
    private String observaciones;
    @OneToOne
    private Duenio unDuenio;

    public Mascota() {
    }

    public Mascota(int idMascota, String nombreMascota, String color, String raza, String alergico, String atencionEspe, String observaciones, Duenio unDuenio) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.color = color;
        this.raza = raza;
        this.alergico = alergico;
        this.atencionEspe = atencionEspe;
        this.observaciones = observaciones;
        this.unDuenio = unDuenio;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencionEspe() {
        return atencionEspe;
    }

    public void setAtencionEspe(String atencionEspe) {
        this.atencionEspe = atencionEspe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getUnDuenio() {
        return unDuenio;
    }

    public void setUnDuenio(Duenio unDuenio) {
        this.unDuenio = unDuenio;
    }
    
    
    
    
    
}
