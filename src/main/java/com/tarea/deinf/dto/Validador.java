
package com.tarea.deinf.dto;


import java.awt.Component;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class Validador {
   public static final String numerotlf="Formato:codigo pais + numero de hasta 12 digitos";
   public static final String prefijo="Formato:numero comprendido entre 1 y 999";
   public static final String codigo="Formato:dos vocales mayusculas o vocal mayuscula y digito";

    public static boolean formatoTelefono(String numTelf,Component p){
        if(numTelf.matches("\\d{12,15}")){
            return true;
        }else{
            mostarErrores(numerotlf,"ERROR FORMATO TELEFONO",p);
            return false;
        }
        
    }
    
    public static  boolean formatoCodigoCompania(String codigo,Component p){
         if (codigo.matches("[A-Z][1-9]"))return true;
        else if (codigo.matches("[A-Z][A-Z]"))return true;
        else{
            mostarErrores(Validador.codigo,"ERROR FORMATO CODIGO",p);
            return false;
        }
    }
    public static boolean formatoCodigoVuelo(String codigo,Component p){
         if (codigo.matches("[A-Z][1-9]\\d{1,4}"))return true;
        
        else{
            mostarErrores(Validador.codigo,"ERROR FORMATO CODIGO",p);
            return false;
        }
    }
    public static boolean formatoIATA(String iata,Component p){
         if (iata.matches("[A-Z][A-Z][A-Z]"))return true;
        else{
                mostarErrores(Validador.codigo,"ERROR FORMATO IATA",p);
        
            return false;
        }
    }
    public static boolean formatoHora(String hora,Component p){
        if(hora.matches("\\d{2}:\\d{2}"))return true;
        else{
                mostarErrores(Validador.codigo,"ERROR FORMATO HORA",p);
        
            return false;
        }
    }
    public static boolean formatoNumVuelo(String vuelo,Component p){
        if(vuelo.matches("\\d{1,4}")) return true;
        else{
                mostarErrores(Validador.codigo,"ERROR FORMATO NUMERO VUELO",p);
        
            return false;
        }
    }
    public static boolean formatoDiasOpera(String dias,Component p){
        if (dias.matches("[L]?[M]?[X]?[J]?[V]?[S]?[D]?")) return true;
        else{
                mostarErrores(Validador.codigo,"ERROR FORMATO DIAS QUE OPERA",p);
        
            return false;
        }
    }
    private static int[] convertirDatosFechas(String fecha){
        int[] datos=new int[3];
        StringBuffer aux=new StringBuffer(4);
        int j=0;
        char c='/';
        //recorremos por primera vez el string hasta encontrar /
        for (int i=0;i<fecha.length();i++){
            if(fecha.charAt(i)!=c){
            aux.append(fecha.charAt(i));
            }else{
                datos[j]=Integer.parseInt(aux.toString());
                int capacity=aux.capacity();
                aux.delete(0, capacity-1);
                j++;
            }
    }
        datos[j]=Integer.parseInt(aux.toString());
        return datos;
}
    public static boolean validacionFechaVuelo(String fechaVuelo,Vuelo v){
        int[]fecha=convertirDatosFechas(fechaVuelo);// formato de la fecha en enteros
        Calendar c=Calendar.getInstance();//instancia de Calendar con la fecha actual
        c.set(fecha[0],fecha[1], fecha[2]);//ponemos al Calendar al fecha del vuelo
        char dia=convertirDiaDelaSemana(c.get(Calendar.DAY_OF_WEEK));//nos devuelve el dia de la semana de la fcha del vuelo 1Domingo 7 Sabado
        String periocidad=v.getDiasOpera();//tenemos los dias que opera
        for (int i=0;i<periocidad.length();i++){//iteramos para ver si existen coincidencias
           if(periocidad.charAt(i)==dia){
               return true;
           }
    }
       return false;
    }
    private static char convertirDiaDelaSemana(int valor){
        switch(valor){
            case 1 -> {
                return 'D';
            }
            case 2 -> {
                return 'L';
            }
            case 3 -> {
                return 'M';
            }
            case 4 -> {
                return 'X';
            }
            case 5 -> {
                return 'J';
            }
            case 6 -> {
                return 'V';
            }
        }
        return 'S';
    }
    protected static void mostarErrores(String mensaje,String titulo,Component p){    
        JOptionPane.showMessageDialog(p, mensaje,titulo,JOptionPane.ERROR_MESSAGE);
    }
}
