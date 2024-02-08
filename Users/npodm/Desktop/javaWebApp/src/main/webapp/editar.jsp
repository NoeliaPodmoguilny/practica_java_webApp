
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar usuario</title>
    </head>
    <body>
        <% Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");%>
        <h1> Editar usuario: </h1>
        <form action="SvEditarUsuario" method="POST">
            <p><label> DNI: </label><input type="text" name="dni" value="<%= usu.getDni()%>"></p>
            <p><label> NOMBRE: </label><input type="text" name="nombre" value="<%= usu.getNombre()%>"></p>
            <p><label> APELLIDO: </label><input type="text" name="apellido" value="<%= usu.getApellido()%>"></p>
            <p><label> TELEFONO: </label><input type="text" name="telefono" value="<%= usu.getTelefono()%>"></p>
            <button type="submit"> Guardar </button>
        </form>
    </body>
</html>
