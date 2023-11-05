
package com.tarea.deinf.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompaniaAerea implements Serializable{
    private String nombre;
    private String direccion;
    private String municipio;
    private String tlfPasajeros;
    private String tlfAeropuertos;
    private String codigo;
    private int prefijo;
    private static int incPref;
    private static List<CompaniaAerea> listaCompanias=new ArrayList<>();
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public CompaniaAerea(String nombre, String direccion, String municipio, String tlfPasajeros, String tlfAeropuertos,String codigo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.tlfPasajeros = tlfPasajeros;
        this.tlfAeropuertos = tlfAeropuertos;
        this.prefijo=setPrefijo();
        this.codigo=codigo;
    }

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public CompaniaAerea() {
    }

  
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTlfPasajeros() {
        return tlfPasajeros;
    }

    public void setTlfPasajeros(String tlfPasajeros) {
        this.tlfPasajeros = tlfPasajeros;
    }

    public String getTlfAeropuertos() {
        return tlfAeropuertos;
    }

    public void setTlfAeropuertos(String tlfAeropuertos) {
        this.tlfAeropuertos = tlfAeropuertos;
    }
    private static int setPrefijo(){
        incPref++;
        return incPref;
    }
    //busca si existe la compañia con el mismo codigo y nombre
    public static boolean buscarCompania(String codigo,String nombre){
        for (CompaniaAerea ca:listaCompanias){
            if (ca.getCodigo().equals(codigo)|| ca.getNombre().equals(nombre))return true;
        }
        return false;
    }
    //eliminar una compañia por su prefijo ya que es el unico id de la lista
    public static boolean eliminarCompania(int prefijo){
        Iterator<CompaniaAerea> it=listaCompanias.iterator();
        CompaniaAerea ca;
        while(it.hasNext()){
            ca=it.next();
            if (ca.getPrefijo()==prefijo){
                it.remove();
                return true;
            }
        }
        return false;
    }
    //anaadir una compañia a la lista
    public static void anaidirCompania(CompaniaAerea c){
        listaCompanias.add(c);
    }
    public static List<CompaniaAerea> getListaCompanias(){
        return listaCompanias;
    }
    //modifica los datos que no esten vacios de la compania que tenga el prefijo psasdo por parametro
    public static boolean modificarCompañia(int prefijo,String nombre,String direccion,String municipio,String tlfPas,String tlfArpto,String codigo){
        Iterator<CompaniaAerea> it=listaCompanias.iterator();
        CompaniaAerea compania;
        while(it.hasNext()){
            compania=it.next();
            if (compania.getPrefijo()==prefijo){
                if(nombre.length()!=0)compania.setNombre(nombre);
                if(direccion.length()!=0)compania.setDireccion(direccion);
                if(municipio.length()!=0)compania.setMunicipio(municipio);
                if(tlfPas.length()!=0)compania.setTlfPasajeros(tlfPas);
                if(tlfArpto.length()!=0)compania.setTlfAeropuertos(tlfArpto);
                if(codigo.length()!=0)compania.setCodigo(codigo);
                return true;
            }
        }
        return false;
    }
}
