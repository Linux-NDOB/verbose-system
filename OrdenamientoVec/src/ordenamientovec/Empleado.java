/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientovec;

import javax.swing.JOptionPane;

/**
 *
 * @author Jhon
 */
public class Empleado {
    private int id;
    private String nombre;
    private String genero;
    private double salariob;
    private double salarioneto;
    private int estrato;
    private int he;
    private int fechavin;

    public Empleado(int id, String nombre, String genero, double salariob, int estrato, int he, int fechavin, double salarioneto) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.salariob = salariob;
        this.estrato = estrato;
        this.he = he;
        this.fechavin = fechavin;
        this.salarioneto = salarioneto;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getSalariob() {
        return salariob;
    }

    public void setSalariob(double salariob) {
        this.salariob = salariob;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public int getHe() {
        return he;
    }

    public void setHe(int he) {
        this.he = he;
    }

    public int getFechavin() {
        return fechavin;
    }

    public void setFechavin(int fechavin) {
        this.fechavin = fechavin;
    }

    public double getSalarioneto() {
        return salarioneto;
    }

    public void setSalarioneto(double salarioneto) {
        this.salarioneto = salarioneto;
    }
      

    
    public void Mostrar(){
        String info= "Los datos del Empleado son: \n";
        info += "ID del Empleado: "+getId()+"\n";
        info += "Nombre del Empleado: "+getNombre()+"\n";
        info += "Género del Empleado: "+getGenero()+"\n";
        info += "Salario base: "+getSalariob()+"\n";
        info += "Estrato del Empleado: "+getEstrato()+"\n";
        info += "H.E laboradas: "+getHe()+"\n";
        info += "Fecha de vinculación del empleado: "+getFechavin();
        
        
        
        
        JOptionPane.showMessageDialog(null, info);
        
    }
    
}
