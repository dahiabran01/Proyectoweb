package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.udea.model.Usuario;
import com.udea.utils.ConexionBD;


public class UsuarioDAO {
  // Métodos para hacer un CRUD (Create, Read, Update, Delete) de un usuario
  private static final String INSERTAR_USUARIO = "INSERT INTO personas (nombre, email, contraseña_encriptada) VALUES (?, ?, ?)";
  private static final String SELECCIONAR_USUARIO_EMAIL = "SELECT * FROM personas WHERE email = ?";
  private static final String SELECCIONAR_TODOS = "SELECT * FROM personas";
  private static final String ELIMINAR_USUARIO = "DELETE FROM personas WHERE email = ?";
  private static final String ACTUALIZAR_USUARIO = "UPDATE personas SET nombre = ?, email = ?, contraseña_encriptada = ? WHERE email = ?";
  
  
  // Crear un usuario
  public void insertarUsuario(Usuario nuevoUsuario) {
    try (
        ConexionBD databaseCn = new ConexionBD();
        Connection conexion = databaseCn.getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_USUARIO)) {
      preparedStatement.setString(1, nuevoUsuario.getNombre());
      preparedStatement.setInt(2, nuevoUsuario.getCedula());
      preparedStatement.setString(3, nuevoUsuario.getCiudad());
      preparedStatement.setString(4, nuevoUsuario.getContraseña_encriptada());
      preparedStatement.setString(5, nuevoUsuario.getEmail());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al insertar un usuario: " + e.getMessage());
    }
  }

  // Se retorna un solo usuario por eso Usuario que es el objeto/modelo que se va a retornar
  public Usuario seleccionarUsuarioPorCedula(int cedula) {
    Usuario usuario = null;
    try (
        ConexionBD databaseCn = new ConexionBD();
        Connection conexion = databaseCn.getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_USUARIO_EMAIL)) {
      preparedStatement.setInt(1, cedula);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        usuario = new Usuario();
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCedula(resultSet.getInt("cedula"));
        usuario.setCiudad(resultSet.getString("ciudad"));
        usuario.setContraseña_encriptada(resultSet.getString("contraseña_encriptada"));
        usuario.setEmail(resultSet.getString("email"));
      }
    } catch (SQLException e) {
      System.out.println("Error al seleccionar un usuario por cédula: " + e.getMessage());
    }
    return usuario;
  }

  // Se va a retornar una lista de usuarios por eso List<Usuario>
  public List<Usuario> seleccionarTodosUsuarios() {
    // Creando una nueva lista de usuarios
    List<Usuario> usuarios = new ArrayList<>();
    try (
        ConexionBD databaseCn = new ConexionBD();
        Connection conexion = databaseCn.getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODOS)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Usuario usuario = new Usuario();
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCedula(resultSet.getInt("cedula"));
        usuario.setCiudad(resultSet.getString("ciudad"));
        usuario.setContraseña_encriptada(resultSet.getString("contraseña_encriptada"));
        usuario.setEmail(resultSet.getString("email"));
        usuarios.add(usuario);
      }
    } catch (SQLException e) {
      System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
    }
    return usuarios;
  }
}