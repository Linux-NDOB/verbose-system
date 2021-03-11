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
public class OrdenamientoVec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        VecObjeto lstPC = null;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
            "Menú Principal \n"+
            "1. Crear y llenar vector \n"+
            "2. Buscar por ID de Empleado \n"+
            "3. Listado ordenando los empleados según su salario neto de mayor a menor \n"+
            "4. Listado con la información de los empleados, "
            + "ordenados alfabéticamente de forma ascendente por sus nombres \n"+
            "5. listado con la información de los empleados, ordenados por estrato en forma descendentemente\n"+
            "6. Salir \n"+
            "Entre su opción: ?"        
            ));
            switch(op){
                case 1:
                    lstPC = new VecObjeto();
                    lstPC.LLenarVec();
                    lstPC.setNeto();
                break;
                case 2:
                    lstPC.CalcNeto();
                break;
                case 3:
                    lstPC.quickSort(0, lstPC.vec.length-1);
                    lstPC.MostrarVec();
                break;
                case 4:
                    lstPC.setSeleccion();
                    lstPC.MostrarVec();
                break;
                case 5:
                    lstPC.shell();
                    lstPC.MostrarVec();
                break;
                case 6:
                    JOptionPane.showMessageDialog(null, 
                    "Adios!!!");
                break;
                default:
                    JOptionPane.showMessageDialog(null, 
                    "Opción invalida!!");
            }
            
        }while(op!=6);
        System.exit(0);
    }
    
}
