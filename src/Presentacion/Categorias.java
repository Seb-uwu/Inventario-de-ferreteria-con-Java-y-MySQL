package Presentacion;

import Datos.CategoriaDB;
import Datos.Conexion;
import Entidad.Categoria;
import Logica.CategoriaL;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Categorias extends javax.swing.JFrame {

    CategoriaL objCategoriaL = new CategoriaL();
    Categoria objCategoria = new Categoria();
    CategoriaDB CATEGORIA = new CategoriaDB();
    DefaultTableModel modelo = new DefaultTableModel();

    public Categorias() throws SQLException {
        initComponents();
        modelo.addColumn("ID");
        modelo.addColumn("Categoria");
        this.setLocationRelativeTo(null);
        CATEGORIA.Combo_box(cboCatProd);
        jtableCategoria.setModel(modelo);
        cargarjtabla();
        cboCatProd.addItem("Tornillos");
        cboCatProd.addItem("Clavos");
        cboCatProd.addItem("Brocas");
        cboCatProd.addItem("Alambres");
        cboCatProd.addItem("Herramientas");
        cboCatProd.addItem("Conexiones de Agua");
        cboCatProd.addItem("Pegamento");
        cboCatProd.addItem("Pernos");
        cboCatProd.addItem("Pintura");
        cboCatProd.addItem("Focos");
        cboCatProd.addItem("Cinta");
        cboCatProd.addItem("Electronico");
        cboCatProd.addItem("Cables");

    }

    public void limpiar() {
        txtCatProd.setText("");
        txtIdCategoria.setText("");
        cboCatProd.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdCategoria = new javax.swing.JTextField();
        cboCatProd = new javax.swing.JComboBox<>();
        txtCatProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAñadirCat = new javax.swing.JButton();
        btnActuCat = new javax.swing.JButton();
        btnElimiCat = new javax.swing.JButton();
        btnBuscarCat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtabla = new javax.swing.JScrollPane();
        jtableCategoria = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(144, 38, 35));

        txtIdCategoria.setEnabled(false);
        txtIdCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdCategoriaKeyTyped(evt);
            }
        });

        txtCatProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCatProdKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Categoria:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categoria del producto:");

        btnAñadirCat.setBackground(new java.awt.Color(255, 204, 102));
        btnAñadirCat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAñadirCat.setText("Agregar");
        btnAñadirCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirCatActionPerformed(evt);
            }
        });

        btnActuCat.setBackground(new java.awt.Color(102, 204, 255));
        btnActuCat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActuCat.setText("Actualizar");
        btnActuCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuCatActionPerformed(evt);
            }
        });

        btnElimiCat.setBackground(new java.awt.Color(255, 255, 102));
        btnElimiCat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnElimiCat.setText("Eliminar");
        btnElimiCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimiCatActionPerformed(evt);
            }
        });

        btnBuscarCat.setBackground(new java.awt.Color(204, 153, 255));
        btnBuscarCat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarCat.setText("Buscar");
        btnBuscarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCatActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(235, 0, 0));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO Y SUPRESIÓN DE CATEGORIAS");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/Atras_png (2).png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/ferreteria-logo-png_icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableCategoriaMouseClicked(evt);
            }
        });
        jtabla.setViewportView(jtableCategoria);

        jLabel13.setText("Búsqueda:");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCatProd)
                            .addComponent(cboCatProd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAñadirCat, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActuCat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnElimiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtabla, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtabla, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCatProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cboCatProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAñadirCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnActuCat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnElimiCat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCatProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCatProdKeyTyped
        Character a = evt.getKeyChar();
        if (!Character.isLetter(a) && a !=KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCatProdKeyTyped

    private void txtIdCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCategoriaKeyTyped
        //LIMITE DE CARACTERES//
        if (txtIdCategoria.getText().length() == 4/*LIMITE*/) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdCategoriaKeyTyped

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Menú menú = new Menú();
        menú.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked
    public void cargarjtabla() throws SQLException {
        jtableCategoria.setModel(DbUtils.resultSetToTableModel(objCategoriaL.fillCategoria()));
    }
    private void btnAñadirCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirCatActionPerformed

        if (txtCatProd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacios, verifique su información");
        } else {
            modelo.addRow(new Object[]{txtIdCategoria.getText(), txtCatProd.getText()});
            jtableCategoria.setModel(modelo);
//            objCategoria.setCod_Categoria(Integer.parseInt(txtIdCategoria.getText()));
            objCategoria.setCategoria(txtCatProd.getText());
            if (objCategoriaL.Graba_categoria(objCategoria)) {
                JOptionPane.showMessageDialog(null, "Se grabó correctamente");
                try {
                    cargarjtabla();
                } catch (SQLException ex) {
                    Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                }
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se grabó correctamente");
            }
        }

    }//GEN-LAST:event_btnAñadirCatActionPerformed

    private void btnActuCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuCatActionPerformed

        objCategoria.setCategoria(txtCatProd.getText());
        objCategoria.setCod_Categoria(Integer.parseInt(txtIdCategoria.getText()));
        if (objCategoriaL.Actualiza_Categoria(objCategoria)) {
            JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            try {
                cargarjtabla();
            } catch (SQLException ex) {
                Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No se modificó correctamente");
        }
    }//GEN-LAST:event_btnActuCatActionPerformed

    private void btnElimiCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiCatActionPerformed
        if (objCategoriaL.Eliminar_Categoria(String.valueOf(txtIdCategoria.getText()))) {
            JOptionPane.showMessageDialog(null, "Se eliminó con éxito");
            try {
                cargarjtabla();
            } catch (SQLException ex) {
                Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No se eliminó");
        }
    }//GEN-LAST:event_btnElimiCatActionPerformed

    private void btnBuscarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCatActionPerformed
        objCategoria = objCategoriaL.Busca_Categoria(JOptionPane.showInputDialog("Inserte su Código de Categoria"));
        if ((objCategoria.getCategoria() == "Nada")) {
            JOptionPane.showMessageDialog(null, "Codigo no existe");
            limpiar();
        } else {
            limpiar();
            txtIdCategoria.setText(String.valueOf(objCategoria.getCod_Categoria()));
            txtCatProd.setText(objCategoria.getCategoria());
        }
    }//GEN-LAST:event_btnBuscarCatActionPerformed

    private void jtableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableCategoriaMouseClicked
        DefaultTableModel model = (DefaultTableModel) jtableCategoria.getModel();
        int SelectedRowIndex = jtableCategoria.getSelectedRow();
        txtIdCategoria.setText(model.getValueAt(SelectedRowIndex, 0).toString());
        txtCatProd.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        cboCatProd.setSelectedItem(model.getValueAt(SelectedRowIndex, 1).toString());

    }//GEN-LAST:event_jtableCategoriaMouseClicked

    public void buscarporcodcat(String text) {
        DefaultTableModel result = objCategoriaL.BarraBuscarCategoria(text);
        jtableCategoria.setModel(result);
    }
    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        String categoria = txtBusqueda.getText();
        buscarporcodcat(categoria);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Categorias().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Categorias.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActuCat;
    private javax.swing.JButton btnAñadirCat;
    private javax.swing.JButton btnBuscarCat;
    private javax.swing.JButton btnElimiCat;
    private javax.swing.JComboBox<String> cboCatProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jtabla;
    private javax.swing.JTable jtableCategoria;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCatProd;
    private javax.swing.JTextField txtIdCategoria;
    // End of variables declaration//GEN-END:variables
}
