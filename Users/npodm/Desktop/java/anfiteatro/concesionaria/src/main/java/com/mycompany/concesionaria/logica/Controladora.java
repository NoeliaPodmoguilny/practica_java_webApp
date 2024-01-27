package com.mycompany.concesionaria.logica;

import com.mycompany.concesionaria.igu.ConsultaAuto;
import com.mycompany.concesionaria.persistencia.ControladoraPersistencia;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
            
    public void agregarAuto(String modelo, String marca, String color, String motor, String patente, int cantPuertas) {
        
        Automovil auto = new Automovil();
        
        auto.setMarca(marca);
        auto.setModelo(modelo);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        
        controlPersis.agregarAuto(auto);
    }

    public List<Automovil> traerAutos() {
        return controlPersis.traerAutos();
    }

    public void borrarAuto(int idAuto) {
        controlPersis.borrarAuto(idAuto);
    }

    public Automovil traerAuto(int idAuto) {
        return controlPersis.traerAuto(idAuto);
    }

    public void modificarAuto(Automovil auto, String marca, String modelo, String motor, String color, String patente, int cantPuertas) {
        //seteo los registros de auto
        auto.setMarca(marca);
        auto.setModelo(modelo);
        auto.setColor(color);
        auto.setMotor(motor);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        
        controlPersis.modificarAuto(auto);
        
    }
    
    

    
    
}
