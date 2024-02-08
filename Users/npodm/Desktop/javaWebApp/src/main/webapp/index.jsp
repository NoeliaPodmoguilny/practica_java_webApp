
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page - Form prueba</title>
    </head>
    <body>
        <h1> Alta nuevo usuario: </h1>
        <form action="SvUsuarios" method="POST">
            <p><label> DNI: </label><input type="text" name="dni"></p>
            <p><label> NOMBRE: </label><input type="text" name="nombre"></p>
            <p><label> APELLIDO: </label><input type="text" name="apellido"></p>
            <p><label> TELEFONO: </label><input type="text" name="telefono"></p>
            <button type="submit"> Enviar </button>
        </form>
        
        <h1>Ver lista de usuarios: </h1>
        <p>Hacer click en el siguiente botón</p>
        <form action="SvUsuarios" method="GET">
            <button type="submit">Mostrar usuarios</button>
        </form>
        
        <h1>Editar usuario </h1>
        <p>Ingrese ID de usuario a editar: </p>
        <form action="SvEditarUsuario" method="GET">
            <p><label> ID: </label><input type="text" name="id_usuarioEdit"></p>
            <button type="submit">Editar usuarios</button>
        </form>
        
        <h1>Eliminar usuario </h1>
        <p>Ingrese ID de usuario a eliminar: </p>
        <form action="SvEliminarUsuario" method="POST">
            <p><label> ID: </label><input type="text" name="id_usuario"></p>
            <button type="submit">Eliminar usuarios</button>
        </form>

    </body>
</html>
