/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udea.dao;

import com.udea.model.Propiedad;
import com.udea.utils.ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PropiedadDAO {
  // Métodos para hacer un CRUD (Create, Read, Update, Delete) de un usuario
    private static final String INSERTAR_PROPIEDAD= "INSERT INTO propiedades (idPropiedad, idPropietario, nombrepropiedad) VALUES (?, ?, ?)";
    private static final String SELECCIONAR_PROPIEDAD = "SELECT * FROM propiedad WHERE cedula = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM propiedad";
    private static final String ELIMINAR_PROPIEDAD = "DELETE FROM propiedad WHERE cedula = ?";


  // Crear una propiedad
  public void insertarPropiedad(Propiedad nuevaPropiedad) {
    try (
        ConexionBD databaseCn = new ConexionBD();
        Connection conexion = databaseCn.getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_PROPIEDAD)) {
      preparedStatement.setInt(1, nuevaPropiedad.getIdPropietario());
      preparedStatement.setInt(2, nuevaPropiedad.getIdPropietario());
      preparedStatement.setString(3, nuevaPropiedad.getnombrepropiedad());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al insertar un usuario: " + e.getMessage());
    }
  }

  

    
}
