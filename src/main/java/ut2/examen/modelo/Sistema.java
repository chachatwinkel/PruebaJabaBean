/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut2.examen.modelo;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;


/**
 *
 * @author samah
 */
@XmlRootElement(name = "sistema")

public class Sistema implements Serializable{
     private String nombre;
     private String componente;

    public Sistema() {
    }

    public Sistema(String nombre, String componente) {
        this.nombre = nombre;
        this.componente = componente;
    }

    /**
     * @return the nombre
     */
     @XmlAttribute(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the componente
     */
     @XmlElement(name = "componente")
    public String getComponente() {
        return componente;
    }

    /**
     * @param componente the componente to set
     */
    public void setComponente(String componente) {
        this.componente = componente;
    }
     
     
             
    
}
