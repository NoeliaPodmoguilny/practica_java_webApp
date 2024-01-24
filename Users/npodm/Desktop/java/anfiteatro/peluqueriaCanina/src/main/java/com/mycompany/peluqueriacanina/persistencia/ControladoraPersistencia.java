package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenioMascota, Mascota mascota) {
        duenioJpa.create(duenioMascota);
        mascotaJpa.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int idMascota) {
        try {
            mascotaJpa.destroy(idMascota);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int idMascota) {
        return mascotaJpa.findMascota(idMascota);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDueniio(int idDuenio) {
        return duenioJpa.findDuenio(idDuenio);
    }

    public void modificarDueniio(Duenio dueniio) {
        try {
            duenioJpa.edit(dueniio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
