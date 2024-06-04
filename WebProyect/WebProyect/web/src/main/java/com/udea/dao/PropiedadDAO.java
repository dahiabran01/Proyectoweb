/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udea.dao;

import com.udea.model.Propiedad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PropiedadDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/tecnicas";
    private String USER_DB = "root";
    private String PASSWORD_DB = "2345";
    
     // Métodos para hacer un CRUD (Create, Read, Update, Delete) de un usuario
  private static final String INSERTAR_PROPIEDAD= "INSERT INTO propiedades (idPropiedad, idPropietario) VALUES (?, ?)";
  private static final String SELECCIONAR_PROPIEDAD = "SELECT * FROM propiedad WHERE cedula = ?";
  private static final String SELECCIONAR_TODOS = "SELECT * FROM propiedad";
  private static final String ELIMINAR_PROPIEDAD = "DELETE FROM propiedad WHERE cedula = ?";

    public PropiedadDAO() {
    }
    
      // Conexión a la base de datos
  protected Connection getConnection() {
    Connection conexion = null;
    try {
      //Importante esta línea para que el driver sepa que se va a conectar a una base de datos MariaDB
      Class.forName("org.mariadb.jdbc.Driver");
      System.out.println("Conectando a la base de datos...");
      // Le pasamos la URL de la base de datos, el usuario y la contraseña para
      // conectarnos a la base de datos
      conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
      System.out.println(conexion);
    } catch (ClassNotFoundException e) {
      System.out.println("Error: MariaDB JDBC Driver no encontrado.");
    } catch (SQLException e) {
      System.out.println("Error al conectar a la base de datos: " + e.getMessage());
      e.printStackTrace();
    }
    return conexion;
  }

  // Crear una propiedad
  public void insertarPropiedad(Propiedad nuevaPropiedad) {
    try (
        Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_PROPIEDAD)) {
      preparedStatement.setInt(2, nuevaPropiedad.getIdPropietario());
      preparedStatement.setInt(2, nuevaPropiedad.getIdPropiedad());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al insertar un usuario: " + e.getMessage());
    }
  }

    
}
