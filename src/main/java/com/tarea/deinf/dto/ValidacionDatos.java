
package com.tarea.deinf.dto;


import javax.swing.JOptionPane;


public class ValidacionDatos {
   public static final String numerotlf="Formato:codigo pais + numero de hasta 12 digitos";
   public static final String prefijo="Formato:numero comprendido entre 1 y 999";
   public static final String codigo="Formato:dos vocales mayusculas o un digito y vocal mayuscula";

    public static boolean ValidacionNumeroTelefono(String numTelf){
        if(numTelf.matches("\\d{12,15}")){
            return true;
        }else{
            mostarErrores(numerotlf);
            return false;
        }
        
    }
    public static boolean validacionPrefijo(int numero){
        if (numero<1 || numero>999){
            mostarErrores(prefijo);
            return false;
        }
        return true;
    }
    public static  boolean validacionCodigo(String codigo){
         if (codigo.matches("[A-Z][1-9]"))return true;
        else if (codigo.matches("[A-Z][A-Z]"))return true;
        else{
            mostarErrores(ValidacionDatos.codigo);
            return false;
        }
    }
    public static boolean validacionIATA(String iata){
         if (iata.matches("[A-Z][A-Z][A-Z]"))return true;
        else{
            
            return false;
        }
    }
    public static boolean validacionHora(String hora){
        if(hora.matches("\\d{2}:\\d{2}"))return true;
        else{
            
            return false;
        }
    }
    public static boolean validacionNumVuelo(String vuelo){
        if(vuelo.matches("\\d{1,4}")) return true;
        else{
            
            return false;
        }
    }
    public static boolean validacionDiasOpera(String dias){
        if (dias.matches("[L]?[M]?[X]?[J]?[V]?[S]?[D]?")) return true;
        else{
            return false;
        }
    }
    private static void mostarErrores(String mensaje){    
        JOptionPane.showMessageDialog(null, mensaje,"ERROR DE VALIDACION",JOptionPane.ERROR_MESSAGE);
    }
}
