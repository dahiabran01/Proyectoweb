package com.udea.servlets;

import com.udea.dao.UsuarioDAO;
import com.udea.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    public RegistroServlet() {
        this.usuarioDAO = new UsuarioDAO();
    }

    //GET , UPDATE, POST, DELETE son métodos HTTP
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String ciudad = request.getParameter("ciudad");
        String contraseña = request.getParameter("contraseña");
        String email = request.getParameter("email");

        // Se encripta la contraseña utilizando la libreria 'jBCrypt'
        String contraseñaEncriptada = encriptarContraseña(contraseña);

        Usuario nuevoUsuario = new Usuario(nombre, cedula, ciudad, contraseñaEncriptada, email);
        usuarioDAO.insertarUsuario(nuevoUsuario);

        // Redireccionamos a la página de registro exitoso
        response.sendRedirect("registro-exitoso.jsp");
    }

    private String encriptarContraseña(String contraseña) {
        return BCrypt.hashpw(contraseña, BCrypt.gensalt());
    }
}
