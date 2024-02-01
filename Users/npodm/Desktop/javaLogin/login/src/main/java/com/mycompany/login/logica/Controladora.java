package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }

    //llama a controlPersis para traer la lista de usuarios de la bd y corroborar que exista
    public Usuario validarUsuario(String usuario, String contrasenia) {
        //inicializamos la ariable mensaje
//        String mensaje = "";
        Usuario user = null;

        //creamos la lista de usuarios que va a llamar al metodo traerUsuarios()
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        //recorremos la lista para buscar el usuario que coincida con los datos que ingresamos
        for (Usuario us : listaUsuarios) {
            System.out.println(us.getNombre() + " " + us.getContrasenia());
            if (us.getNombre().equals(usuario)) {
                if (us.getContrasenia().equals(contrasenia)) {
//                    mensaje = retorna el objeto user;
                    user = us;
                    return user;
                } else {
//                    mensaje = "Contraseña incorrecta";
                    user = null;
                    return user;
                }
            } else {
                user = null;
//                return user;
//                mensaje = "Usuario incorrecto";
            }
        }
        return user;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contras, String rolRecibido) {
        Usuario us = new Usuario();
        us.setNombre(usuario);
        us.setContrasenia(contras);

        //para rol debemos instanciar un nuevo rol
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            us.setUnRol(rolEncontrado);
        }

        int id = this.buscarUltimaIdUser();
        us.setId(id + 1);
        controlPersis.crearUsuario(us);
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();

        for (Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUser() {
        List<Usuario> listaUsuarios = this.traerUsuarios();

        Usuario us = listaUsuarios.get(listaUsuarios.size() - 1);
        return us.getId();
    }

    public void borrarUsuario(int idUser) {
        controlPersis.borrarUsuario(idUser);
    }

    public Usuario traerUsuario(int idUser) {
        return controlPersis.traerUsuario(idUser);
    }

    public void editarUsuario(Usuario us, String usuario, String contras, String rolRecibido) {
        us.setNombre(usuario);
        us.setContrasenia(contras);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            us.setUnRol(rolEncontrado);
        }
        controlPersis.editarUsuario(us);
    }

}
