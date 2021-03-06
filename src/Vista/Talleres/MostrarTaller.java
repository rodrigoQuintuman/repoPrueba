/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Talleres;

import Operaciones.OperacionesTaller;
import Validacion.Validar;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigo
 */
public class MostrarTaller extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();
    private String[] titulo = {"Id", "Sucursal", "Email", "Calle", "N°", "Comuna", "Ciudad", "Telefono"};
    OperacionesTaller op = new OperacionesTaller();

    /**
     * Creates new form MostrarTaller
     */
    public MostrarTaller() throws SQLException {
        initComponents();
        modelo = new DefaultTableModel(null, titulo) {
            @Override //Sobreescribiendo el metodo, para no permitir que los campos de la tabla puedan ser editados
            public boolean isCellEditable(int row, int column) {
                if (column == 8) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        jTableTaller.setModel(modelo);
        op.llenarTablaTaller(modelo);
        //tamanoTabla();
        Validar.validarCaracter(jtNonbreTaller, 20);

    }

    public void habilitarBotonBuscar() {
        if (jtNonbreTaller.getText().isEmpty()) {
            jbBuscar.setEnabled(false);
        } else {
            jbBuscar.setEnabled(true);
        }

    }

    public void tamanoTabla() {
        if (jTableTaller.getColumnModel().getColumnCount() > 0) {
            jTableTaller.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTableTaller.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableTaller.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTableTaller.getColumnModel().getColumn(5).setPreferredWidth(130);
            jTableTaller.getColumnModel().getColumn(6).setPreferredWidth(130);
        }

    }

    public void limpiarTabla() {
        for (int i = 0; i < jTableTaller.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }

    }

    public void Actualizar() {

        try {
            limpiarTabla();
            op.llenarTablaTaller(modelo);
            jtNonbreTaller.setText("");

            tamanoTabla();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTaller.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTaller = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtNonbreTaller = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 0));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mostrar Taller");

        jbBuscar.setText("Buscar");
        jbBuscar.setEnabled(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jTableTaller.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTaller);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unnamed.png"))); // NOI18N

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Taller:");

        jtNonbreTaller.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtNonbreTallerCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jbActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(jbEliminar))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtNonbreTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNonbreTaller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        String nombre = jtNonbreTaller.getText();
        try {
            modelo = new DefaultTableModel(null, titulo);
            jTableTaller.setModel(modelo);
            op.buscarTaller(modelo, nombre);
            tamanoTabla();
            if (0 == modelo.getRowCount()) {
                JOptionPane.showMessageDialog(null, "Taller no se encuentra en la BD");
                Actualizar();

            }

        } catch (SQLException ex) {
            Logger.getLogger(MostrarTaller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtNonbreTallerCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtNonbreTallerCaretUpdate
        habilitarBotonBuscar();
    }//GEN-LAST:event_jtNonbreTallerCaretUpdate

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed

        Actualizar();

    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
      
         int aux = jTableTaller.getSelectedRow();
        boolean estado = false;
        if (aux == -1) {

            JOptionPane.showMessageDialog(null, "Seleccione un Taller en la table para eliminar");

        } else {

            int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminarlo? ");

            if (opcion == 0) {

                String nombre = (String) jTableTaller.getValueAt(aux, 1);
                estado = op.eliminarTaller(nombre);
                if (!estado) {
                    JOptionPane.showMessageDialog(null, "Taller no pudo ser  eliminado");
                    Actualizar();
                }else{
                JOptionPane.showMessageDialog(null, "Taller eliminado con exito");
                Actualizar();
                }
            }   
        }
        
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTaller;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JTextField jtNonbreTaller;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
