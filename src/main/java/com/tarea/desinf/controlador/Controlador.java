
package com.tarea.desinf.controlador;

import com.tarea.deinf.dto.CompaniaAerea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Controlador {
    private static List<CompaniaAerea> listaCompanias=new ArrayList<>();//lista de compañias 
    private static List<CompaniaAerea> listaaux=new ArrayList<>();//lista de compañias auxiliar
    private static final File COMPANIAS=new File("compania.csv");
   
    //escribir fichero CSV
    public static boolean escribirFicheroCSV(){
        if (listaCompanias.isEmpty()) return false;
        else{
        PrintWriter prw=null;
        try {
            prw =new PrintWriter(COMPANIAS);
            for (CompaniaAerea c:listaCompanias){
                prw.println(String.valueOf(c.getPrefijo()));
                prw.println(c.getNombre());
                prw.println(c.getDireccion());
                prw.println(c.getMunicipio());
                prw.println(c.getTlfPasajeros());
                prw.println(c.getTlfAeropuertos());
                prw.println(c.getCodigo());
            }
            prw.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
        }
        
    }
   public static boolean leerFicherosCSV(){
       if (COMPANIAS.exists()){
        if (!listaCompanias.isEmpty()){
            listaCompanias.clear();    
        } 
        BufferedReader bfr=null;
           try {
               bfr=new BufferedReader(new FileReader(COMPANIAS));
               String []datos=new String[7];
               int i=0;
               while ((datos[i]=bfr.readLine())!=null){
                    i++;
                    if(i==7){
                        Controlador.anadirCompaniaBis(Integer.parseInt(datos[0]),datos[1], datos[2],datos[3],datos[4],datos[5],datos[6]);
                        i=0;
                    }
               }
           } catch (FileNotFoundException ex) {
               
           } catch (IOException ex) {
               
           }finally{
            try {
                bfr.close();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
   }
       return true;
   }
    
    
   
    private static int ultimoPrefijo(){
        int prefijo=0;
        for (CompaniaAerea c:listaCompanias){
            prefijo=c.getPrefijo();
        }
        return prefijo;
    }
    
    
    //añade compania a la lista
    public static void anaidirCompania(String nombre,String direccion,String municipio,String tlfPasjro,String tlfArpto,String codigo){
        listaCompanias.add(new CompaniaAerea(nombre,direccion,municipio,tlfPasjro,tlfArpto,codigo));
    }
    private static void anadirCompaniaBis(int prefijo,String nombre,String direccion,String municipio,String tlfPasjro,String tlfArpto,String codigo){
        CompaniaAerea compania=new CompaniaAerea(nombre, direccion, municipio, tlfPasjro, tlfArpto, codigo);
        compania.setPrefijo(prefijo);
        listaCompanias.add(compania);

    }
    //elimina una compañia segun segun prefijo
    public static boolean eliminarCompania(int prefijo){
        Iterator<CompaniaAerea> it=listaCompanias.iterator();//iterador para la lista
        CompaniaAerea compania;
        while(it.hasNext()){//itera hasta el final de la kista
            compania=it.next();
            if(compania.getPrefijo()==prefijo){//comrpueba si existe coincidencia y borra la compania de la lista
                it.remove();
                return true;
            }
        }
        return false;
    }
    //comprueba si la compañia segun prefijo existe en la lista
    public static boolean existeCompania(int prefijo){
        for (CompaniaAerea c:listaCompanias){
            if (c.getPrefijo()==prefijo)return true;
        }
        return false;
    }
    //devuelve un array de string  de los datos de una compañia segun su prefijo
    public static String[] datosCompaniaSeleccionada(int prefijo){
        if (existeCompania(prefijo)){
            String []datos=new String[6];
            for (CompaniaAerea c:listaCompanias){
                if (c.getPrefijo()==prefijo){
                    datos[0]=c.getNombre();
                    datos[1]=c.getDireccion();
                    datos[2]=c.getMunicipio();
                    datos[3]=c.getTlfPasajeros();
                    datos[4]=c.getTlfAeropuertos();
                    datos[5]=c.getCodigo();
                    return datos;
                }
            }
        }
        return null;
    }
    //devuleve una copia de la lista de compañias
    public static List<CompaniaAerea> getListaCompanias(){
        return listaCompanias;
    }
    //rellena una lista de compañias a exceprcion de la que se pasa el prefijo por parametro
    public static void rellenarListaAux(int prefijo){
        if(!listaaux.isEmpty()){
            listaaux.clear();
        } 
        for (CompaniaAerea c:listaCompanias){
            if(c.getPrefijo()!=prefijo){
                listaaux.add(c);
            }
        }
    }
    //devuelve la lista auxliiar de compañias 
    public static List<CompaniaAerea> getListaAux() {
       return listaaux;
    }
    //devuelve una compañia segun su codigo
    public static CompaniaAerea getCompaniaCodigo(String codigo){
        for (CompaniaAerea c:listaCompanias){
            if (c.getCodigo().equals(codigo)) return c;
        }
        return null;
    }
    //devuelde una compañia segun su nombre
    public static CompaniaAerea getCompaniaNombre(String nombre){
        for (CompaniaAerea c:listaCompanias){
            if(c.getNombre().equals(nombre))return c;
        }
        return null;
    }
    public static boolean existeCoincidencias(String nombre,String direccion,String municipio,String tlfPAs,String tlfArpto,String codigo){
        for (CompaniaAerea c:listaCompanias){
            if(c.getNombre().compareToIgnoreCase(nombre)==0) return true;
            if(c.getDireccion().compareToIgnoreCase(direccion)==0 && c.getMunicipio().compareToIgnoreCase(municipio)==0) return true;
            if(c.getTlfPasajeros().compareToIgnoreCase(tlfPAs)==0) return true;
            if(c.getTlfAeropuertos().compareToIgnoreCase(tlfArpto)==0) return true;
            if(c.getCodigo().compareToIgnoreCase(codigo)==0) return true;
        }
        return false;
    }
    //modificar los datos de una compañia segun su prefijo
    public static boolean modificarCompania(int prefijo,String nombre,String direccion,String municipio,String tlfPas,String tlfArpto,String codigo){
       Iterator<CompaniaAerea> it=listaCompanias.iterator();
       CompaniaAerea compania;
        while (it.hasNext()){
            compania=it.next();
            if (compania.getPrefijo()==prefijo){
                if(!nombre.isEmpty())compania.setNombre(nombre);
                if(!direccion.isEmpty())compania.setDireccion(direccion);
                if(!municipio.isEmpty())compania.setMunicipio(municipio);
                if(!tlfPas.isEmpty())compania.setTlfPasajeros(tlfPas);
                if(!tlfArpto.isEmpty())compania.setTlfAeropuertos(tlfArpto);
                if(!codigo.isEmpty())compania.setCodigo(codigo);
                return true;
            }
        }
        return false;
    }
}

