package Vista.Automovil;

import Clases.Automovil;
import Clases.Color;
import Clases.DuenoAuto;
import Clases.Marca;
import Clases.Modelo;
import Operaciones.LlenarCombo;
import Operaciones.OperacionesAuto;
import Validacion.Validar;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author byron
 */
public class RegistrarAutomovil extends javax.swing.JPanel {
    //Instancias de Clases a Ocupar
    LlenarCombo llenarCombo = new LlenarCombo();
    OperacionesAuto op = new OperacionesAuto();

    /**
     * Creates new form RegistrarAutomovil
     */
    public RegistrarAutomovil() throws SQLException {
        initComponents();
        Validar.validarNumero(jTextFieldNumMotor, 9);
        Validar.validarNumero(jTextFieldKilometraje, 9);
        Validar.validarCaracter(jtfPatenteLetra, 4);
        Validar.validarNumero(jtfPatenteNumero, 2);
        llenarCombo.llenarComboRutDueno(jcRutCliente);
        llenarCombo.llenarComboColor(jComboColor);
        llenarCombo.llenarComboMarca(jComboMarca);
        llenarCombo.llenarComboModelo(jComboModelo, 0);

    }

    public void Actualizar() throws SQLException {
        llenarCombo.llenarComboRutDueno(jcRutCliente);
    }
    
    /**
     * Metodo que permite limpiar los campos despues de una accion
     */
    public void limpiar() {
        jTextFieldKilometraje.setText("");
        jTextFieldNumMotor.setText("");
        jtfPatenteLetra.setText("");
        jtfPatenteNumero.setText("");
        jComboAno.setSelectedIndex(0);
        jComboColor.setSelectedIndex(0);
        jComboMarca.setSelectedIndex(0);
        jComboModelo.setSelectedIndex(0);
        jcRutCliente.setSelectedIndex(0);
    }
    
    /**
     * Metodo que permite habilita el boton registrar siempre y cuando los
     * campos contengan informacion y que los JCombo esten con una pcion valida
     */
    public void habilitarBotonRegistrar() {

        int PatenteLetra = jtfPatenteLetra.getText().length();
        int PatenteNumero = jtfPatenteNumero.getText().length();
        String NumMotor = jTextFieldNumMotor.getText();
        String Kilometraje = jTextFieldKilometraje.getText();

        if (PatenteLetra != 4 || PatenteNumero != 2 || Kilometraje.isEmpty() || NumMotor.isEmpty() || 0 == jComboAno.getSelectedIndex() || 0 == jComboMarca.getSelectedIndex() || 0 == jcRutCliente.getSelectedIndex() || 0 == jComboModelo.getSelectedIndex() || 0 == jComboColor.getSelectedIndex()) {
            jButtonRegistrar.setEnabled(false);
        } else {
            jButtonRegistrar.setEnabled(true);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jtfPatenteLetra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNumMotor = new javax.swing.JTextField();
        jtfPatenteNumero = new javax.swing.JTextField();
        jTextFieldKilometraje = new javax.swing.JTextField();
        jcRutCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboMarca = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboModelo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboColor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboAno = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 153, 153));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 0));
        kGradientPanel1.setkGradientFocus(1300);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 51));

        jtfPatenteLetra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfPatenteLetraCaretUpdate(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unnamed.png"))); // NOI18N

        jTextFieldNumMotor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldNumMotorCaretUpdate(evt);
            }
        });

        jtfPatenteNumero.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfPatenteNumeroCaretUpdate(evt);
            }
        });

        jTextFieldKilometraje.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldKilometrajeCaretUpdate(evt);
            }
        });

        jcRutCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcRutCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcRutClienteItemStateChanged(evt);
            }
        });

        jLabel5.setText("Marca");

        jComboMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Marca", "Audi", "BMW", "Chevrolet", "Kia", "Hyundai", "Jeep" }));
        jComboMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboMarcaItemStateChanged(evt);
            }
        });

        jLabel6.setText("Modelo");

        jComboModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Modelo", "Modelo 1", "Modelo 2", "Modelo 3" }));
        jComboModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboModeloItemStateChanged(evt);
            }
        });

        jLabel7.setText("Color");

        jLabel2.setText("Patente");

        jComboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Color", "Color 1", "Color 2", "Color 3" }));
        jComboColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboColorItemStateChanged(evt);
            }
        });

        jLabel3.setText("Nª de Motor");

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setEnabled(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Kilometraje");

        jLabel8.setText("Rut Dueño");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registrar Automovil");

        jLabel9.setText("Año");

        jComboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Año", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
        jComboAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboAnoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonRegistrar)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldNumMotor)
                                            .addComponent(jTextFieldKilometraje)
                                            .addComponent(jComboMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addComponent(jtfPatenteLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jtfPatenteNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)))))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcRutCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboAno, 0, 127, Short.MAX_VALUE))))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfPatenteLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfPatenteNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addComponent(jButtonRegistrar)
                .addGap(27, 27, 27)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        Automovil auto = new Automovil();

        auto.setPatente(jtfPatenteLetra.getText() + jtfPatenteNumero.getText());
        auto.setnMotor(jTextFieldNumMotor.getText());
        auto.setKilometraje(jTextFieldKilometraje.getText());
        auto.setAno(jComboAno.getModel().getSelectedItem().toString());
        
        //Recuperamos el objeto dentro del Jcombo seleccionado y procedemos a sacar su Id(Modelo,Color,Dueño)
        Modelo mode = (Modelo) jComboModelo.getSelectedItem();
        int id = mode.getIdModelo();
        auto.setIdModelo(String.valueOf(id));
        Color color = (Color) jComboColor.getSelectedItem();
        int idColor = color.getIdColor();
        auto.setIdColor(String.valueOf(idColor));
        DuenoAuto dueno = (DuenoAuto) jcRutCliente.getSelectedItem();
        int idDueno = dueno.getIdDueno();
        auto.setIdCliente(String.valueOf(idDueno));

        boolean estado = op.ingresarAuto(auto);

        if (estado) {
            JOptionPane.showMessageDialog(null, "Auto ingresado correctamente");
            limpiar();

        } else {
            JOptionPane.showMessageDialog(null, "Ups Algo Salio mal y no se pudo registrar el Auto");
        }


    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jtfPatenteLetraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfPatenteLetraCaretUpdate
        habilitarBotonRegistrar();
    }//GEN-LAST:event_jtfPatenteLetraCaretUpdate

    private void jTextFieldNumMotorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldNumMotorCaretUpdate
        habilitarBotonRegistrar();
    }//GEN-LAST:event_jTextFieldNumMotorCaretUpdate

    private void jTextFieldKilometrajeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldKilometrajeCaretUpdate
        habilitarBotonRegistrar();
    }//GEN-LAST:event_jTextFieldKilometrajeCaretUpdate

    private void jtfPatenteNumeroCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfPatenteNumeroCaretUpdate
        habilitarBotonRegistrar();
    }//GEN-LAST:event_jtfPatenteNumeroCaretUpdate

    private void jComboMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboMarcaItemStateChanged
        habilitarBotonRegistrar();
        Marca marca = (Marca) this.jComboMarca.getSelectedItem();//recuperamos el objeto (Ciudad) que esta en jComboBox, segun el Item Seleccionda
        int idMar = marca.getIdMarca();//Recuperamos el Id del Objeto Ciudad 
        try {
            llenarCombo.llenarComboModelo(jComboModelo, idMar);//enviamos el JComboBoxComuna y el Id de la de la Ciudad 
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarAutomovil.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jComboMarcaItemStateChanged

    private void jComboModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboModeloItemStateChanged
        habilitarBotonRegistrar();

    }//GEN-LAST:event_jComboModeloItemStateChanged

    private void jComboColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboColorItemStateChanged
        habilitarBotonRegistrar();

    }//GEN-LAST:event_jComboColorItemStateChanged

    private void jcRutClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcRutClienteItemStateChanged
        habilitarBotonRegistrar();

    }//GEN-LAST:event_jcRutClienteItemStateChanged

    private void jComboAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboAnoItemStateChanged
        habilitarBotonRegistrar();
    }//GEN-LAST:event_jComboAnoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<String> jComboAno;
    private javax.swing.JComboBox<String> jComboColor;
    private javax.swing.JComboBox<String> jComboMarca;
    private javax.swing.JComboBox<String> jComboModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldKilometraje;
    private javax.swing.JTextField jTextFieldNumMotor;
    private javax.swing.JComboBox<String> jcRutCliente;
    private javax.swing.JTextField jtfPatenteLetra;
    private javax.swing.JTextField jtfPatenteNumero;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
