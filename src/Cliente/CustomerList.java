/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Cliente;

import Main.Customer;
import static Main.MainWindows.getCustomer;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author David Sandoval Salvador
 */
public class CustomerList extends javax.swing.JInternalFrame {

    DefaultTableModel dmCustomers = new DefaultTableModel();
    Customer[] customerlist;

    /**
     * Creates new form CustomerList
     */
    public CustomerList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableCustomer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCustomerList = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        jScrollPane1.setAutoscrolls(true);

        JTableCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(JTableCustomer);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Clientes ");

        btnCustomerList.setText("Listar Clientes");
        btnCustomerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnCustomerList)
                .addGap(228, 228, 228)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnCustomerList))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerListActionPerformed
        try {
            SetModelo();
            customerlist = getCustomer().SequentialList();
            setDatos();
            resizeColumnWidth(JTableCustomer);
            JTableCustomer.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCustomerListActionPerformed

    private void SetModelo() {
        String[] Column = {"DNI", "Nombre", "Apellido", "Direccion", "Nacionalidad", "RUC", "Télefono", "Celular", "Edad", "Fecha de Nacimiento"};
        dmCustomers.setColumnIdentifiers(Column);
        JTableCustomer.setModel(dmCustomers);
    }

    private void setDatos() {
        Object[] datos1 = new Object[dmCustomers.getColumnCount()];
        dmCustomers.setRowCount(0);
        for (Customer c : customerlist) {
            datos1[0] = c.getDNI();
            datos1[1] = c.getName();
            datos1[2] = c.getLastName();
            datos1[3] = c.getAddrees();
            datos1[4] = c.getNationality();
            datos1[5] = c.getRUC();
            datos1[6] = c.getPhoneNumber();
            datos1[7] = c.getCellphoneNumber();
            datos1[8] = c.getAge();
            datos1[9] = c.getBirthdayDate();
            dmCustomers.addRow(datos1);
        }
        JTableCustomer.setModel(dmCustomers);
    }

    public void ColumnSize() {
        TableColumnModel columnModel = JTableCustomer.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(80);//DN1
        columnModel.getColumn(1).setPreferredWidth(100);//Nombre
        columnModel.getColumn(2).setPreferredWidth(200);//Apellido
        columnModel.getColumn(3).setPreferredWidth(200);//Direccion
        columnModel.getColumn(4).setPreferredWidth(80);//Nacionalidad
        columnModel.getColumn(5).setPreferredWidth(80);//RUC
        columnModel.getColumn(6).setPreferredWidth(80);//Télefono
        columnModel.getColumn(7).setPreferredWidth(80);//Celular
        columnModel.getColumn(8).setPreferredWidth(30);//Edad
        columnModel.getColumn(9).setPreferredWidth(80);//Fecha Nacimiento
    }

    public void resizeColumnWidth(JTable table) {
        //Se obtiene el modelo de la columna
        TableColumnModel columnModel = table.getColumnModel();
        //Se obtiene el total de las columnas
        for (int column = 0; column < table.getColumnCount(); column++) {
            //Establecemos un valor minimo para el ancho de la columna
            int width = 80; //Min Width
            //Obtenemos el numero de filas de la tabla
            for (int row = 0; row < table.getRowCount(); row++) {
                //Obtenemos el renderizador de la tabla
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                //Creamos un objeto para preparar el renderer
                Component comp = table.prepareRenderer(renderer, row, column);
                //Establecemos el width segun el valor maximo del ancho de la columna
                width = Math.max(comp.getPreferredSize().width + 10, width);

            }
            //Se establece una condicion para no sobrepasar el valor de 300
            //Esto es Opcional
            if (width > 300) {
                width = 300;
            }
            //Se establece el ancho de la columna
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableCustomer;
    private javax.swing.JButton btnCustomerList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
