
package com.tarea.deinf.dto;

public class CompaniaAerea {
    private String nombre;
    private String direccion;
    private String municipio;
    private String tlfPasajeros;
    private String tlfAeropuertos;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    private int prefijo;

    public CompaniaAerea(String nombre, String direccion, String municipio, String tlfPasajeros, String tlfAeropuertos,int prefijo,String codigo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.tlfPasajeros = tlfPasajeros;
        this.tlfAeropuertos = tlfAeropuertos;
        this.prefijo=prefijo;
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

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the tlfPasajeros
     */
    public String getTlfPasajeros() {
        return tlfPasajeros;
    }

    /**
     * @param tlfPasajeros the tlfPasajeros to set
     */
    public void setTlfPasajeros(String tlfPasajeros) {
        this.tlfPasajeros = tlfPasajeros;
    }

    /**
     * @return the tlfAeropuertos
     */
    public String getTlfAeropuertos() {
        return tlfAeropuertos;
    }

    /**
     * @param tlfAeropuertos the tlfAeropuertos to set
     */
    public void setTlfAeropuertos(String tlfAeropuertos) {
        this.tlfAeropuertos = tlfAeropuertos;
    }
    

}
