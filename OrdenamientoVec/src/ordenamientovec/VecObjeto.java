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
public class VecObjeto {
    
    public Empleado vec[];
    
    public VecObjeto(){
        int tama=Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos empleados se "
                + " registrarán?"));
        vec = new Empleado [tama];
        
        for(int i=0;i<vec.length;i++){
            vec[i] = new Empleado(-1, "", "", -1, -1, -1,-1,-1);
        }
        
    }
    
    public int ConfirID(int id){
        for(int i=0;i<vec.length;i++){
            if(vec[i].getId() == id){
                return i;
            } 
        }        
        return -1;
    }
    public void LLenarVec(){
        int pos=-1, id;
        
      for(int i=0; i<vec.length;i++){
          do{
              id=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su ID de empleado."));
              pos=ConfirID(id);
              if(pos == -1){
                vec[i].setId(id);
              }
              else{
                  JOptionPane.showMessageDialog(null, "La ID que ingresó ya existe. \n"
                          + "Intente nuevamente...");
              }
                  
          }while(pos>=0);
          vec[i].setNombre(JOptionPane.showInputDialog(null, "Ingrese su nombre."));
          vec[i].setGenero(JOptionPane.showInputDialog(null, "Ingrese su Género."));
          vec[i].setSalariob(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese su salario básico.")));
          vec[i].setEstrato(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su estrato.")));
          vec[i].setHe(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de HE que laboró.")));
          vec[i].setFechavin(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de vinculación en la empresa.")));
           
         
      }
    }

    public void setNeto() {

        for (int i = 0; i < vec.length; i++) {

            double salud = 0, pension = 0, arl = 0,
                    total = 0, sbt = 0, valP = 0;


            salud = vec[i].getSalariob() * 0.04;
            pension = vec[i].getSalariob() * 0.0375;
            arl = vec[i].getSalariob() * 0.02;


            if (vec[i].getEstrato() == 1 || vec[i].getEstrato() == 2) {
                sbt = 78000;
            }

            int fecha = vec[i].getFechavin();
            int horasE = vec[i].getHe();
            int año = 2021 - fecha;


            if (año > 10) {
                valP = horasE * 45000;
            } else if (año >= 5 && año <= 10) {
                valP = horasE * 35000;
            } else if (año >= 3 && año <= 5) {
                valP = horasE * 30000;
            } else if (año < 3) {
                valP = horasE * 25000;
            }

            total = vec[i].getSalariob() - salud - pension - arl + sbt + valP;
            vec[i].setSalarioneto(total);

        }
    }
    
    public void MostrarVec(){
        for(int i=0;i<vec.length;i++){
            vec[i].Mostrar();
            
        }
    }
   
    public int BuscarID(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la ID del empleado a buscar"));
        for(int i=0;i<vec.length;i++){
            if(vec[i].getId() == id){
                return i;
            } 
        }        
        return -1;
    }
    
    public void CalcNeto(){
        int pos = BuscarID();
        double salud = 0, pension = 0, arl = 0, 
                total = 0, sbt = 0, valP=0;
        
             if(pos == -1){
            JOptionPane.showMessageDialog(null, "LA ID INGRESADA NO ESTÁ REGISTRADA!!!");
             
              }
             else{
              vec[pos].Mostrar();
             
             salud=vec[pos].getSalariob()*0.04;
             pension=vec[pos].getSalariob()*0.0375;
             arl=vec[pos].getSalariob()*0.02;
           
             
                if(vec[pos].getEstrato() == 1 || vec[pos].getEstrato() == 2){
                     sbt=78000;
               }
                int fecha = vec[pos].getFechavin();
                int horasE = vec[pos].getHe();
                int año = 2021 - fecha;

                

                if (año > 10){
                     valP = horasE * 45000;
                }else
                    if (año >= 5 && año <= 10){
                        valP = horasE *35000;
                    }
                    else
                        if (año >=3 && año <= 5){
                            valP = horasE * 30000;
                        }
                        else
                            if (año < 3){
                                valP = horasE * 25000;
                            }
            
               total=vec[pos].getSalariob()-salud-pension-arl+sbt+valP;
               vec[pos].setSalarioneto(total);
             }
               JOptionPane.showMessageDialog(null, "DETALLADO DE NÓMINA DEL EMPLEADO: \n"
                                              + "SUELDO BASICO: "+vec[pos].getSalariob()+"\n"
                                              + "H.E LABORADAS: "+vec[pos].getHe()+"\n"
                                              + "VALOR H.E: " +valP+"\n"
                                              + "APORTE SALUD: "+salud+"\n"
                                              + "APORTE PENSIÓN: "+pension+"\n"
                                              + "APORTE ARL: "+arl+"\n"
                                              + "SUBSIDIO TTE: "+sbt+"\n"
                                              + "NETO A PAGAR: "+"$"+vec[pos].getSalarioneto());
          
    }
     public void quickSort(int Begin, int End) {
        if(Begin>=End) return ;
        double pivote = vec[Begin].getSalarioneto();
        int izq = Begin+1;
        int der = End;
        Empleado temporal=null;
        while(izq<=der) {
            while(izq<=End && vec[izq].getSalarioneto()> pivote) izq++;
            while(der>Begin && vec[der].getSalarioneto()<=pivote) der--;

            if(izq<der)
            {
                temporal = new Empleado(
                        vec[izq].getId(),
                        vec[izq].getNombre(), 
                        vec[izq].getGenero(),
                        vec[izq].getSalariob(),
                        vec[izq].getEstrato(),
                        vec[izq].getHe(), 
                        vec[izq].getFechavin(), 
                        (int) vec[izq].getSalarioneto()
                        );

                vec[izq].setId(vec[der].getId());
                vec[izq].setNombre(vec[der].getNombre());
                vec[izq].setGenero(vec[der].getGenero());
                vec[izq].setSalariob(vec[der].getSalariob());
                vec[izq].setEstrato(vec[der].getEstrato());
                vec[izq].setHe(vec[der].getHe());
                vec[izq].setFechavin(vec[der].getFechavin());

                vec[der].setId(temporal.getId());
                vec[der].setNombre(temporal.getNombre());
                vec[der].setGenero(temporal.getGenero());
                vec[der].setSalariob(temporal.getSalariob());
                vec[der].setEstrato(temporal.getEstrato());
                vec[der].setHe(temporal.getHe());
                vec[der].setFechavin(temporal.getFechavin());
                
            }
        }

        if(der>Begin) {
            temporal = new Empleado(
                        vec[Begin].getId(),
                        vec[Begin].getNombre(), 
                        vec[Begin].getGenero(),
                        vec[Begin].getSalariob(),
                        vec[Begin].getEstrato(),
                        vec[Begin].getHe(), 
                        vec[Begin].getFechavin(), 
                        (int) vec[Begin].getSalarioneto()
                    
                    );
                vec[Begin].setId(vec[der].getId());
                vec[Begin].setNombre(vec[der].getNombre());
                vec[Begin].setGenero(vec[der].getGenero());
                vec[Begin].setSalariob(vec[der].getSalariob());
                vec[Begin].setEstrato(vec[der].getEstrato());
                vec[Begin].setHe(vec[der].getHe());
                vec[Begin].setFechavin(vec[der].getFechavin());
                
            
                vec[der].setId(temporal.getId());
                vec[der].setNombre(temporal.getNombre());
                vec[der].setGenero(temporal.getGenero());
                vec[der].setSalariob(temporal.getSalariob());
                vec[der].setEstrato(temporal.getEstrato());
                vec[der].setHe(temporal.getHe());
                vec[der].setFechavin(temporal.getFechavin());
                
        }
        quickSort(Begin, der-1);
        quickSort(der+1, End);
    }    
       public int MenorPosicion(int comienzo){
        int i;
        int posMenor;
        String menor;
        posMenor = comienzo;

        menor = vec[comienzo].getNombre();

        for (i=comienzo+1; i<vec.length; i++){

            if (vec[i].getNombre().compareTo(menor)< 0){
                menor = vec[i].getNombre();
                posMenor = i;
            }
        }

        return posMenor;
    }

    public void setSeleccion(){

        Empleado temporal = null;
        int i, posMenor; 

        for (i=0; i<vec.length; i++){
            posMenor = MenorPosicion(i);

            if(posMenor!=i){

                temporal = new Empleado
                      ( vec[i].getId(),
                        vec[i].getNombre(), 
                        vec[i].getGenero(),
                        vec[i].getSalariob(),
                        vec[i].getEstrato(),
                        vec[i].getHe(), 
                        vec[i].getFechavin(), 
                        (int) vec[i].getSalarioneto()
                      );

                vec[i].setId(vec[posMenor].getId());
                vec[i].setNombre(vec[posMenor].getNombre());
                vec[i].setGenero(vec[posMenor].getGenero());
                vec[i].setSalariob(vec[posMenor].getSalariob());
                vec[i].setEstrato(vec[posMenor].getEstrato());
                vec[i].setHe(vec[posMenor].getHe());
                vec[i].setFechavin(vec[posMenor].getFechavin());
                


                vec[posMenor].setId(temporal.getId());
                vec[posMenor].setNombre(temporal.getNombre());
                vec[posMenor].setGenero(temporal.getGenero());
                vec[posMenor].setSalariob(temporal.getSalariob());
                vec[posMenor].setEstrato(temporal.getEstrato());
                vec[posMenor].setHe(temporal.getHe());
                vec[posMenor].setFechavin(temporal.getFechavin());
                
            }
        }
        
    }
      public void shell( ){
        int salto, i;
        boolean cambios;
        Empleado Tem = null;
        for(salto = vec.length/2; salto!=0; salto/=2){
            cambios = true;
            while(cambios){
                cambios = false;
                for(i=salto; i<vec.length; i++)
                    if(vec[i-salto].getEstrato()<(vec[i].getEstrato())){

                        Tem = new Empleado( 
                        vec[i].getId(),
                        vec[i].getNombre(), 
                        vec[i].getGenero(),
                        vec[i].getSalariob(),
                        vec[i].getEstrato(),
                        vec[i].getHe(), 
                        vec[i].getFechavin(), (int) vec[i].getSalarioneto());
                        
                        vec[i].setId(vec[i-salto].getId());
                        vec[i].setNombre(vec[i-salto].getNombre());
                        vec[i].setGenero(vec[i-salto].getGenero());
                        vec[i].setSalariob(vec[i-salto].getSalariob());
                        vec[i].setEstrato(vec[i-salto].getEstrato());
                        vec[i].setHe(vec[i-salto].getHe());
                        vec[i].setFechavin(vec[i-salto].getFechavin());
                        


                        vec[i-salto].setId(Tem.getId());
                        vec[i-salto].setNombre(Tem.getNombre());
                        vec[i-salto].setGenero(Tem.getGenero());
                        vec[i-salto].setSalariob(Tem.getSalariob());
                        vec[i-salto].setEstrato(Tem.getEstrato());
                        vec[i-salto].setHe(Tem.getHe());
                        vec[i-salto].setFechavin(Tem.getFechavin());
                        
                        

                        cambios = true;
                    }
            }
        }
    }
 
        
    
}
