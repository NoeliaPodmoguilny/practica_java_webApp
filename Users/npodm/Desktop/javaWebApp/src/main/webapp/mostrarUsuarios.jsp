
<%@page import="java.util.List"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
    </head>
    <body>
        <div> 
        <h1>Lista de usuarios registrados</h1>
        <% List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
            int cont = 1;
            for(Usuario us:listaUsuarios){      
        %>
        <p><b>Usuario N°:<%=cont%></b></p>
        <p>ID: <%=us.getId()%> </p>
        <p>DNI: <%=us.getDni()%> </p>
        <p>NOMBRE: <%= us.getNombre()%></p>
        <p>APELLIDO: <%=us.getApellido()%></p>
        <p>TELEFONO: <%=us.getTelefono()%></p>
        <p>-----------------------------------</p>
        </div>
        
        <% cont = cont +1;%>

        <% } %>
    </body>
</html>
