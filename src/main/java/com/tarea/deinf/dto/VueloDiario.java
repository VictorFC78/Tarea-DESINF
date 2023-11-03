
package com.tarea.deinf.dto;


public class VueloDiario {
    private String fechaVuelo;
    private String horaSlida;
    private String horaLlegada;
    private int plazasOcupadas;
    private double precio;

    public VueloDiario() {
    }

    public VueloDiario(String fechaVuelo, String horaSlida, String horaLlegada, int plazasOcupadas, double precio) {
        this.fechaVuelo = fechaVuelo;
        this.horaSlida = horaSlida;
        this.horaLlegada = horaLlegada;
        this.plazasOcupadas = plazasOcupadas;
        this.precio = precio;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getHoraSlida() {
        return horaSlida;
    }

    public void setHoraSlida(String horaSlida) {
        this.horaSlida = horaSlida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
