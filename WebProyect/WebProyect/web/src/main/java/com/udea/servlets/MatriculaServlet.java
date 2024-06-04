package com.udea.servlets;

import com.udea.dao.PropiedadDAO;
import com.udea.model.Propiedad;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registro")
public class MatriculaServlet extends HttpServlet {
    private PropiedadDAO propiedadDao;

    public MatriculaServlet() {
        this.propiedadDao = new PropiedadDAO();
    }

    //GET , UPDATE, POST, DELETE son métodos HTTP
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPropietario = Integer.parseInt(request.getParameter("ownerId"));
        int idPropiedad = Integer.parseInt(request.getParameter("propertyId"));



        Propiedad propiedad = new Propiedad(idPropietario, idPropiedad);
        propiedadDao.insertarPropiedad(propiedad);

        // Redireccionamos a la página de registro exitoso
        response.sendRedirect("registro-exitoso.jsp");
    }
}
