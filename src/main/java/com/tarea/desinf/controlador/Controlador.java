
package com.tarea.desinf.controlador;

import com.tarea.deinf.dto.CompaniaAerea;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Controlador {
    private static List<CompaniaAerea> listaCompanias=new ArrayList<>();//lista de compañias 
    private static List<CompaniaAerea> listaaux=new ArrayList<>();//lista de compañias auxiliar
    //añade compania a la lista
    public static void anaidirCompania(String nombre,String direccion,String municipio,String tlfPasjro,String tlfArpto,String codigo){
        listaCompanias.add(new CompaniaAerea(nombre,direccion,municipio,tlfPasjro,tlfArpto,codigo));
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
        for (CompaniaAerea c:listaaux){
            if(c.getNombre().equals(nombre)) return true;
            if(c.getDireccion().equals(direccion)&& c.getMunicipio().equals(municipio)) return true;
            if(c.getTlfPasajeros().equals(tlfPAs)) return true;
            if(c.getTlfAeropuertos().equals(tlfArpto)) return true;
            if(c.getCodigo().equals(codigo)) return true;
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

