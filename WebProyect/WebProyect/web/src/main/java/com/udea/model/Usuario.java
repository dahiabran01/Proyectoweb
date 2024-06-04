package com.udea.model;

import java.io.Serializable;

public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;

  private String nombre;
  private int cedula;
  private String ciudad;
  private String contraseña_encriptada;
  private String email;

  public Usuario(String nombre, int cedula, String ciudad, String contraseña_encriptada, String email) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.ciudad = ciudad;
    this.contraseña_encriptada = contraseña_encriptada;
    this.email = email;
  }

  public Usuario(String nombre, String ciudad, String contraseña_encriptada, String email) {
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.contraseña_encriptada = contraseña_encriptada;
    this.email = email;
  }

  public Usuario() {
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCedula() {
    return cedula;
  }

  public void setCedula(int cedula) {
    this.cedula = cedula;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getContraseña_encriptada() {
    return contraseña_encriptada;
  }

  public void setContraseña_encriptada(String contraseña_encriptada) {
    this.contraseña_encriptada = contraseña_encriptada;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Usuario: { cedula=" + cedula + ", ciudad=" + ciudad + ", contraseña_encriptada=" + contraseña_encriptada + ", email=" + email + ", nombre=" + nombre + " }";
  }
}
