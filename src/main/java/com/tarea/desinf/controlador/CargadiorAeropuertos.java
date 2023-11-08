
package com.tarea.desinf.controlador;

import com.tarea.deinf.dto.Aeropuerto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargadiorAeropuertos {
    private List<Aeropuerto> aeropuertoDestino;
    private BufferedReader bfr;
   
    private final File f=new File("aeropuertos.csv");
    
    
public CargadiorAeropuertos(){
    this.aeropuertoDestino=new ArrayList<>();
    try {
        this.bfr=new BufferedReader(new FileReader(this.f));
        } catch (FileNotFoundException ex) {
        
        }
}
//añadir a la lista de aeropuertos destino
private void anaidirAeropuertoDestino(String iata,String nombre,String codigo){
    aeropuertoDestino.add(new Aeropuerto(iata,nombre,codigo));
}
//leer fichero con aeropueros 
public boolean leerFicheroCSV(){
    String[] datos=new String[3];
    int i=0;
    if (this.f.length()==0){
        return false;
    }else{
        try {
            while((datos[i]=bfr.readLine())!=null){
                i++;
                if (i==3){
                    i=0;
                    anaidirAeropuertoDestino(datos[0],datos[1],datos[2]);
                   
                }
                
            }
            this.bfr.close();
        } catch (IOException ex) {
           
        }
    }
    return true;
}
//devuelve la lista de los aeropuertos de destino
public List<Aeropuerto> getListaAeropuertos(){
    return this.aeropuertoDestino;
}
}
