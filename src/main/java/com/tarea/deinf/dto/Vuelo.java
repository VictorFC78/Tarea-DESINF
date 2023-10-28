
package com.tarea.deinf.dto;

import java.time.LocalTime;


public class Vuelo {
    private String codigo;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int plazas;
    private String horaSalida;
    private String horaLlegada;
    private String diasOpera;

    public Vuelo() {
    }

    public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, int plazas, String horaSalida, String horaLlegada, String diasOpera) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.plazas = plazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOpera = diasOpera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    
}
