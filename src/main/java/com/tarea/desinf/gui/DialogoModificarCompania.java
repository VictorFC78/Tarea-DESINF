
package com.tarea.desinf.gui;

import com.tarea.deinf.dto.CompaniaAerea;
import com.tarea.deinf.dto.Validador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class DialogoModificarCompania extends javax.swing.JDialog {
    private List<CompaniaAerea> lista;//lista con todas las compañias
    private List<CompaniaAerea> listaaux=new ArrayList<>();//lista con las restantes compañias menos la seleccioinada en la lista
    private List<String> nombres=new ArrayList<>();//lista con los nombres de las compañia 
    private CompaniaAerea compania;
    private DefaultListModel model;
    public DialogoModificarCompania(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //comprueba si la lista no esta vacia, sino esta vacia la rellena la lista de nombres 
        if (rellenarNombres()){
            model=new DefaultListModel();//modelo para la lista 
            Listcompanias.setModel(model);
            for (String l:nombres){ //rellena la lista con la lista de nombres
                model.addElement(l);
            }
            Listcompanias.setSelectedIndex(0);//selecciona el nombre de la lista de la posicion 0
            this.compania=companiaSeleccionada(Listcompanias.getSelectedValue());//devuelve la compañia de la posicion 0
            rellenarListaAux();//rellena la lista auxiliar
            referescarDialogo();//muestra el contenido de la compañia seleccionada en la lista
            
        }
    }
    //rellena un lista de strings con los nombres de la compañia en la,lista
    private boolean rellenarNombres(){
        if (!nombres.isEmpty()){
            nombres.clear();
        }
        lista=CompaniaAerea.getListaCompanias();
        if (!lista.isEmpty()){
            for (CompaniaAerea c:lista){
                nombres.add(c.getNombre());
            }
        return true;
        }
        return false;
    }
    //rellena una lista con todas las compañias menos la seleccionada para comprobaciones
    private void rellenarListaAux(){
        //conocer cual es la compañia seleccionada
        if (!listaaux.isEmpty()){
                listaaux.clear();
            }
        for (CompaniaAerea c:lista){
            
            if(!c.getNombre().equals(this.compania.getNombre())){ 
                listaaux.add(c);
            }
        }
    }
    //devuelve la compañia que esta seleccionada en la lista
    private CompaniaAerea companiaSeleccionada(String nombre){
        for (CompaniaAerea c:lista){
            if (c.getNombre().equals(nombre)) return c;
        }
        return null;
    }
    //muestra los datos de la compañia seleccionada
    private void referescarDialogo(){
        this.compania=companiaSeleccionada(Listcompanias.getSelectedValue());
        mostrarDatosActuales(); 
    }
    //metodo para seleccionar iniicialmente el primer elemnto para mostarlo
    private void mostrarDatosActuales(){
        txtNombre.setText(compania.getNombre());
        txtDireccion.setText(compania.getDireccion());
        txtMunicipio.setText(compania.getMunicipio());
        txtTlfPasjro.setText(compania.getTlfPasajeros());
        txtTlfArpto.setText(compania.getTlfAeropuertos());
        txtCodigo.setText(compania.getCodigo());
    }
    //devuelve un array con los datos nuevos que se quieren cambiar
    private String[] datosNuevos(){
        String []datos=new String[6];
        datos[0]=txtNombreN.getText();
        datos[1]=txtDireccionN.getText();
        datos[2]=txtMunicipioN.getText();
        datos[3]=txtTlfPasjroN.getText();
        datos[4]=txtTlfArptoN.getText();
        datos[5]=txtCodigoN.getText();
        return datos;
    }
    //limpia los txtfields cuando se haya realizado un camboio
    private void limpiarDatosNuevos(){
        txtNombreN.setText("");
        txtDireccionN.setText("");
        txtMunicipioN.setText("");
        txtTlfPasjroN.setText("");
        txtTlfArptoN.setText("");
        txtCodigoN.setText("");
    }
    private boolean coincidenciaNombre(){
        for (CompaniaAerea c:listaaux){
            if (c.getNombre().equals(txtNombreN.getText()))return true;
        }
        return false;
    }
    private boolean coincidenciaMunicipio(){
        for (CompaniaAerea c:listaaux){
            if (c.getMunicipio().equals(txtMunicipioN.getText()))return true;
        }
        return false;
    }
    private boolean coincidenciaDireccion(){
        for (CompaniaAerea c:listaaux){
            if (c.getDireccion().equals(txtDireccionN.getText()))return true;
        }
        return false;
    }
    private boolean coincidenciaTlfPasjro(){
        for (CompaniaAerea c:listaaux){
            if (c.getTlfPasajeros().equals(txtTlfPasjroN.getText()))return true;
        }
        return false;
    }
    private boolean coincidenciaTlfArpto(){
        for (CompaniaAerea c:listaaux){
            if (c.getTlfAeropuertos().equals(txtTlfArptoN.getText()))return true;
        }
        return false;
    }
    private boolean coincidenciaCodigo(){
        for (CompaniaAerea c:listaaux){
            if (c.getCodigo().equals(txtCodigoN.getText()))return true;
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Listcompanias = new javax.swing.JList<>();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        txtTlfPasjro = new javax.swing.JTextField();
        txtTlfArpto = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombreN = new javax.swing.JTextField();
        txtDireccionN = new javax.swing.JTextField();
        txtMunicipioN = new javax.swing.JTextField();
        txtTlfPasjroN = new javax.swing.JTextField();
        txtTlfArptoN = new javax.swing.JTextField();
        txtCodigoN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Listcompanias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListcompaniasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Listcompanias);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Direccion");

        jLabel3.setText("Municipio");

        jLabel5.setText("TlfPasjro");

        jLabel6.setText("TlfArpto");

        jLabel7.setText("Codigo");

        jLabel8.setText("DATOS ACTUALES");

        jLabel9.setText("DATOS NUEVOS");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addComponent(txtDireccion)
                                .addComponent(txtMunicipio)
                                .addComponent(txtTlfPasjro)
                                .addComponent(txtTlfArpto)
                                .addComponent(txtCodigo))
                            .addComponent(jLabel8)))
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreN)
                            .addComponent(txtDireccionN)
                            .addComponent(txtMunicipioN)
                            .addComponent(txtTlfPasjroN)
                            .addComponent(txtTlfArptoN)
                            .addComponent(txtCodigoN, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTlfPasjro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTlfArpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMunicipioN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTlfPasjroN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTlfArptoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnModificar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ListcompaniasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListcompaniasMouseClicked
       
        referescarDialogo();
        rellenarListaAux();
    }//GEN-LAST:event_ListcompaniasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //se cuemprueba si hay coindicencias de los datos actuales con datos de otras compañias
        boolean nombreOk,direccionOk,tlfPasjro,tlfArpto,codigo,municipioOk;
        nombreOk=coincidenciaNombre();
        direccionOk=coincidenciaDireccion();
        tlfPasjro=coincidenciaTlfPasjro();
        tlfArpto=coincidenciaTlfArpto();
        codigo=coincidenciaCodigo();
        municipioOk=coincidenciaMunicipio();
        //si hay coincidencia muestra un mensaje de error
        if (nombreOk || direccionOk || tlfPasjro || tlfArpto || codigo||(direccionOk &&municipioOk)){
            JOptionPane.showMessageDialog(Listcompanias, "Existe coincidencia con otras compañias");
        //sino hay coincidencia se comprueba si los datos nuevos estan vacias, y sino estan vacios que este bien el formato
        }else{
            boolean  tlfPasjroVal=false,tlfArptoVal=false,codigoVal=false,nombreVal=false,direccionVal=false,municipioVal=false;
            boolean tlfPasjroBlank=false,tlfArptoBalnk=false,codigoBlan=false;
            
            if (!txtTlfPasjroN.getText().isEmpty()){
                if(Validador.formatoTelefono(txtTlfPasjroN.getText(), this)){
                        tlfPasjroVal=true;
                    }
            } else tlfPasjroBlank=true;
            if (!txtTlfArptoN.getText().isEmpty()){
                    if(Validador.formatoTelefono(txtTlfArptoN.getText(), this)){
                        tlfArptoVal=true;
                    }
            }else tlfArptoBalnk=true;
            if (!txtCodigoN.getText().isEmpty()){
                    if(Validador.formatoCodigoCompania(txtCodigoN.getText(), this)){
                        codigoVal=true;
                    }
            }else codigoBlan=true;
            //en el caso de que este correcto los formatos de los campos que no esten vaacios se realizar los cambios 
            if ((tlfPasjroBlank || tlfPasjroVal)&&(tlfArptoBalnk || tlfArptoVal) && (codigoBlan || codigoVal)){
                int posicion=Listcompanias.getSelectedIndex();//recupera la posicion de la lista que esta seleccionada
                String [] datos=datosNuevos();//recupera el valor de los datos nuevos
                //modifica los datos que no esten en blanco
                CompaniaAerea.modificarCompañia(this.compania.getPrefijo(), datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
                model.removeAllElements();//limpia la lista
                rellenarNombres();//rellena la lista con los nombres de nuevo ya actualizado
                for (String l:nombres){
                model.addElement(l);
            }
                Listcompanias.setSelectedIndex(posicion);//se selecciona la posicion que estaba seleccionada antes del cambio
                referescarDialogo();//refresca los datos de la compañia en los textfield
                limpiarDatosNuevos();//limpia los datos de los txtfield que recoge los datos nuevos
                //this.dispose();
            }            
    }//GEN-LAST:event_btnModificarActionPerformed
 }
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Listcompanias;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoN;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionN;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtMunicipioN;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreN;
    private javax.swing.JTextField txtTlfArpto;
    private javax.swing.JTextField txtTlfArptoN;
    private javax.swing.JTextField txtTlfPasjro;
    private javax.swing.JTextField txtTlfPasjroN;
    // End of variables declaration//GEN-END:variables
}
