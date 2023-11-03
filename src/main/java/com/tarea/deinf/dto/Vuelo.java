
package com.tarea.deinf.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Vuelo {
    private String codigo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int plazas;
    private String horaSalida;
    private String horaLlegada;
    private String diasOpera;
    private List<VueloDiario> vuelosDiario;
    private CompaniaAerea codCompania;
    public Vuelo() {
    }

    public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, int plazas, String horaSalida, String horaLlegada, String diasOpera,List vuelos, CompaniaAerea compania) {
        this.origen = origen;
        this.destino = destino;
        this.plazas = plazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOpera = diasOpera;
        this.vuelosDiario=new ArrayList<>();
        this.codCompania=compania;
        this.codigo = codCompania.getCodigo()+codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codCompania.getCodigo()+codigo;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDiasOpera() {
        return diasOpera;
    }

    public void setDiasOpera(String diasOpera) {
        this.diasOpera = diasOpera;
    }

    public void anaidirVueloDiario(VueloDiario v){
        vuelosDiario.add(v);
    }
    public VueloDiario buscarVueloDiario(String fecha){
        for (VueloDiario v:vuelosDiario){
            if(v.getFechaVuelo().equals(fecha)){
                return v;
            }
        }
        return null;
    }
     public boolean eliminarVueloDiario(String fecha){
         Iterator<VueloDiario> it=vuelosDiario.iterator();
         VueloDiario v;
         while(it.hasNext()){
             v=it.next();
             if(v.getFechaVuelo().equals(fecha)){
                 it.remove();
                 return true;
         }
         }
         return false;
}
}  
