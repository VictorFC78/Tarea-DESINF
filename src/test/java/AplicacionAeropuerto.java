
import com.tarea.desinf.controlador.Controlador;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 34675
 */
public class AplicacionAeropuerto {
    public static void main(String[] args) {
        
        try {
            Controlador.leerFicnero();
            PantallaPrincipal pantallaPrincipal=new PantallaPrincipal();
            pantallaPrincipal.setVisible(true);
        } catch (FileNotFoundException ex) {
            PantallaPrincipal pantallaPrincipal=new PantallaPrincipal();
            pantallaPrincipal.setVisible(true);
            JOptionPane.showMessageDialog(pantallaPrincipal, "Error al leer de los archivos");
        }
    }
}
