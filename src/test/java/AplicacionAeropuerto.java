
import com.tarea.deinf.dto.Aeropuerto;
import com.tarea.desinf.controlador.Controlador;
import com.tarea.desinf.controlador.CargadiorAeropuertos;
import com.tarea.desinf.gui.PantallaPrincipal;





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
        //crear nuestro aeropuero de origen
        Aeropuerto aeropuertoOrigen=new Aeropuerto("OVD", "Aeropuerto de Asturias", "33016");
        CargadiorAeropuertos controladorVuelos=new CargadiorAeropuertos();
        controladorVuelos.leerFicheroCSV();
        Controlador.leerFicherosCSV();
        PantallaPrincipal pantallaPrincipal=new PantallaPrincipal();
        pantallaPrincipal.setVisible(true);
    }
}
