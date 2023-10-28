
package com.tarea.deinf.dto;


import javax.swing.JOptionPane;


public class ValidacionDatos {
   public static final String numerotlf="Formato:codigo pais + numero de hasta 12 digitos";
   public static final String prefijo="Formato:numero comprendido entre 1 y 999";
   public static final String codigo="Formato:dos vocales mayusculas o un digito y vocal mayuscula";

    public static boolean ValidacionNumeroTelefono(String numTelf){
        if (numTelf.length()>15 || numTelf.length()<12){
            mostarErrores(numerotlf);
            return false;
        }
        else if(numTelf.matches("\\d{12,15}")){
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
        if(codigo.length()!=2){
            mostarErrores(ValidacionDatos.codigo);
            return false;
        }
        else if (codigo.matches("[A-Z][1-9]"))return true;
        else if (codigo.matches("[A-Z][A-Z]"))return true;
        else{
            mostarErrores(ValidacionDatos.codigo);
            return false;
        }
    }
    private static void mostarErrores(String mensaje){    
        JOptionPane.showMessageDialog(null, mensaje,"ERROR DE VALIDACION",JOptionPane.ERROR_MESSAGE);
    }
}
