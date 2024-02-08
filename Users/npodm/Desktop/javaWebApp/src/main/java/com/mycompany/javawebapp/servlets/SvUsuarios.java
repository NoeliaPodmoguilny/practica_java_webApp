package com.mycompany.javawebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = control.traerUsuarios();

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaUsuarios", listaUsuarios);
        
        response.sendRedirect("mostrarUsuarios.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
//        System.out.println(dni +"" + nombre +"" + apellido + "" + telefono);

        Usuario usu = new Usuario();
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setTelefono(telefono);
        
        control.crearUsuario(usu);
        //despues de crear vuelve al index
        response.sendRedirect("index.jsp");
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
