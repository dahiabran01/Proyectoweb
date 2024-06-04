/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udea.model;

public class Propiedad {
    private int idPropietario;
    private int idPropiedad;
    private String nombrepropiedad;

    public Propiedad() {
    }

    public Propiedad(int idPropietario, int idPropiedad) {
        this.idPropietario = idPropietario;
        this.idPropiedad = idPropiedad;
        this.nombrepropiedad = nombrepropiedad;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getnombrepropiedad() {
        return nombrepropiedad;
    }

    public void setnombrepropiedad(String nombrepropiedad) {
        this.nombrepropiedad = nombrepropiedad;
    }
    
    
    
}
