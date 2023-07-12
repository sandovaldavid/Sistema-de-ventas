/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Cliente.CustomerList;
import Cliente.DeleteCustomer;
import Cliente.Register;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author David Sandoval Salvador
 */
public class MainWindows extends javax.swing.JFrame {

    private static Archivo[] archivos;
    private static Customer customer;

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        MainWindows.customer = customer;
    }

    public static Archivo getArchivo(int i) {
        return archivos[i];
    }

    public static void setArchivo(Archivo archivo, int i) {
        MainWindows.archivos[i] = archivo;
    }

    public static Archivo[] getArchivos() {
        return archivos;
    }

    public static void setArchivos(Archivo[] archivos) {
        MainWindows.archivos = archivos;
    }

    /**
     * Creates new form VentanaPrincipal
     */
    public MainWindows() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/Sales_Systems.png")).getImage());
//        ImageIcon ImgCRegister = new ImageIcon(getClass().getResource("/img/Register_Customer.png"));
//        //ImgCRegister = new ImageIcon(ImgCRegister.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
//        JmCRegistrar.setIcon(ImgCRegister);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        JmCliente = new javax.swing.JMenu();
        JmCRegistrar = new javax.swing.JMenuItem();
        JmCList = new javax.swing.JMenuItem();
        JmCDelete = new javax.swing.JMenuItem();
        JmVendedor = new javax.swing.JMenu();
        JmProducto = new javax.swing.JMenu();
        JmRuta = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Ventas");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        JmCliente.setText("Cliente");

        JmCRegistrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JmCRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Register_Customer.png"))); // NOI18N
        JmCRegistrar.setText("Registrar");
        JmCRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCRegistrarActionPerformed(evt);
            }
        });
        JmCliente.add(JmCRegistrar);

        JmCList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JmCList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ListCustomers.png"))); // NOI18N
        JmCList.setText("Listado");
        JmCList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCListActionPerformed(evt);
            }
        });
        JmCliente.add(JmCList);

        JmCDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JmCDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deleteCustomer.png"))); // NOI18N
        JmCDelete.setText("Eliminar");
        JmCDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCDeleteActionPerformed(evt);
            }
        });
        JmCliente.add(JmCDelete);

        jMenuBar1.add(JmCliente);

        JmVendedor.setText("Vendedor");
        jMenuBar1.add(JmVendedor);

        JmProducto.setText("Producto");
        jMenuBar1.add(JmProducto);

        JmRuta.setText("Ruta");
        jMenuBar1.add(JmRuta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JmCRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCRegistrarActionPerformed
        // TODO add your handling code here:
        Register ic = new Register();
        escritorio.add(ic);
        CenterWindow(ic);
        ic.show();

    }//GEN-LAST:event_JmCRegistrarActionPerformed

    private void JmCListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCListActionPerformed
        // TODO add your handling code here:
        CustomerList ic = new CustomerList();
        escritorio.add(ic);
        CenterWindow(ic);
        ic.show();
    }//GEN-LAST:event_JmCListActionPerformed

    private void JmCDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCDeleteActionPerformed
        // TODO add your handling code here:
        DeleteCustomer ic = new DeleteCustomer();
        escritorio.add(ic);
        CenterWindow(ic);
        ic.show();
    }//GEN-LAST:event_JmCDeleteActionPerformed

    public void CenterWindow(JInternalFrame ic) {
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ic.getSize();
        ic.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
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
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MainWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            UIManager.setLookAndFeel(new FlatArcIJTheme());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                MainWindows v = new MainWindows();
                v.setVisible(true);
                v.setLocationRelativeTo(null);
                archivos = new Archivo[1];
                Customer c = new Customer("Customer", "dat");
                archivos[0] = c;
                int i = 0;
                for (Archivo archivo : archivos) {
                    try {
                        archivo.CreateNewFile();
                        archivo.getCab().setRecordSize(c.getSize());
                        archivo.getCab().position();
                        archivo.getCab().Write();
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                setCustomer(c);
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmCDelete;
    private javax.swing.JMenuItem JmCList;
    private javax.swing.JMenuItem JmCRegistrar;
    private javax.swing.JMenu JmCliente;
    private javax.swing.JMenu JmProducto;
    private javax.swing.JMenu JmRuta;
    private javax.swing.JMenu JmVendedor;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
