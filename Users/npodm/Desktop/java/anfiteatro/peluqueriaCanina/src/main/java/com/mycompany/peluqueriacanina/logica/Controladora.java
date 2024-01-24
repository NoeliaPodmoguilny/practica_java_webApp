package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String alergico, String atEspe, String color, String duenio, String observaciones, String raza, String telefono) {
        //creamos el dueño y seteamos sus atr
        Duenio duenioMascota = new Duenio();
        duenioMascota.setNombreDuenio(duenio);
        duenioMascota.setTelefono(telefono);
        
        //creamos mascota y seteamos sus atr
        Mascota mascota = new Mascota();
        mascota.setAlergico(alergico);
        mascota.setAtencionEspe(atEspe);
        mascota.setColor(color);
        mascota.setNombreMascota(nombreMascota);
        mascota.setObservaciones(observaciones);
        mascota.setRaza(raza);
        mascota.setUnDuenio(duenioMascota);
        
        controlPersis.guardar(duenioMascota, mascota);
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int idMascota) {
        controlPersis.borrarMascota(idMascota);
    }

    public Mascota traerMascota(int idMascota) {
        return controlPersis.traerMascota(idMascota);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, String color, String duenio, String telefono, String observaciones, String alergico, String atEspe) {
        //seteo valores mascota
        masco.setNombreMascota(nombreMascota);
        masco.setColor(color);
        masco.setRaza(raza);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencionEspe(atEspe);
        
        controlPersis.modificarMascota(masco);
        
        //seteo valores dueño
        Duenio dueniio = this.buscarDueniio(masco.getUnDuenio().getIdDuenio());
        dueniio.setNombreDuenio(duenio);
        dueniio.setTelefono(telefono);
        
        //llamar a modificar duenio
        this.modificarDueniio(dueniio);
    }

    private Duenio buscarDueniio(int idDuenio) {
        return controlPersis.traerDueniio(idDuenio);
    }

    private void modificarDueniio(Duenio dueniio) {
        controlPersis.modificarDueniio(dueniio);
    }
}
