
package com.tarea.deinf.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Aeropuerto {
    private String iata;
    private String nombre;
    private String municipio;
    private List<Vuelo> vuelos;
    public Aeropuerto() {
    }
    
    public Aeropuerto(String iata, String nombre, String municipio) {
        this.iata = iata;
        this.nombre = nombre;
        this.municipio = municipio;
        vuelos=new ArrayList<>();
        
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public void inaidirVuelo(Vuelo v){
        vuelos.add(v);
    }
    public Vuelo buscarVuelo(String codigoVuelo){
        //buscamos en la lista si existe el vuelo buscado
        for(Vuelo v:vuelos){
            if(v.getCodigo().equals(codigoVuelo)){
                return v;
            }
        }
        return null;
    }
    public boolean eliminarVuelo(String codigoVuelo){
        //iteramos la lista y si existe el vuelo lo eliminamos
        Vuelo v;
        Iterator<Vuelo> it=vuelos.iterator();
        while(it.hasNext()){
            v=it.next();
            if (v.getCodigo().equals(codigoVuelo)){
                it.remove();
                return true;
            }
        }
        return false;
    }
    public List devolverListaVuelos(){
        return vuelos;
    }
}
