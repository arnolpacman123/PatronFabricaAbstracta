/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import abstractfactory.db.DBServiceStackFactory;
import abstractfactory.interfaces.IServiceStackAbstractFactory;
import abstractfactory.rest.RestServiceStackFactory;
import abstractfactory.schemas.Employee;
import abstractfactory.schemas.Product;
import abstractfactory.services.IEmployeesService;
import abstractfactory.services.IProductsService;
import abstractfactory.ws.WSServiceStackFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Asus
 */
public class Client extends javax.swing.JFrame {

    HashMap<String, IServiceStackAbstractFactory> factories;
    IEmployeesService employeesServiceSelected;
    IProductsService productsServiceSelected;

    public Client() {
        factories = new HashMap<>(
                Map.of(
                        "db", new DBServiceStackFactory(),
                        "ws", new WSServiceStackFactory(),
                        "rest", new RestServiceStackFactory()
                )
        );
        initComponents();
        listarTablaEmpleados();
        listarTablaProductos();
    }

    private void listarTablaProductos() {
        String tipoServicio = (String) jCbxProductos.getSelectedItem();
        IServiceStackAbstractFactory factory = factories.get(tipoServicio);
        if (factory != null) {
            productsServiceSelected = factory.createProductsService();
            List<Product> products = productsServiceSelected.getProducts();
            llenarTablaProducts(products);
        }
    }

    private void listarTablaEmpleados() {
        String tipoServicio = (String) jCbxEmpleados.getSelectedItem();
        IServiceStackAbstractFactory factory = factories.get(tipoServicio);
        if (factory != null) {
            employeesServiceSelected = factory.createEmployeesService();
            List<Employee> employees = employeesServiceSelected.getEmployees();
            llenarTablaEmployees(employees);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPnlEmpleados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblEmpleados = new javax.swing.JTable();
        jLblServicioEmpleado = new javax.swing.JLabel();
        jCbxEmpleados = new javax.swing.JComboBox<>();
        jLblEmpleadoNombre = new javax.swing.JLabel();
        jTxtEmpleadoNombre = new javax.swing.JTextField();
        jBtnEmpleadoGuardar = new javax.swing.JButton();
        jPnlProductos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblProductos = new javax.swing.JTable();
        jLblServicioProducto = new javax.swing.JLabel();
        jCbxProductos = new javax.swing.JComboBox<>();
        jLblProductoNombre = new javax.swing.JLabel();
        jTxtProductoNombre = new javax.swing.JTextField();
        jBtnProductoGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPnlEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("EMPLEADOS"));
        jPnlEmpleados.setToolTipText("");

        jTblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "NOMBRE"
                }
        ));
        jScrollPane1.setViewportView(jTblEmpleados);

        jLblServicioEmpleado.setText("SERVICIO");

        jCbxEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"db", "rest", "ws"}));
        jCbxEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbxEmpleadosActionPerformed(evt);
            }
        });

        jLblEmpleadoNombre.setText("NOMBRE");

        jTxtEmpleadoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmpleadoNombreActionPerformed(evt);
            }
        });

        jBtnEmpleadoGuardar.setText("GUARDAR");
        jBtnEmpleadoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEmpleadoGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlEmpleadosLayout = new javax.swing.GroupLayout(jPnlEmpleados);
        jPnlEmpleados.setLayout(jPnlEmpleadosLayout);
        jPnlEmpleadosLayout.setHorizontalGroup(
                jPnlEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlEmpleadosLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPnlEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLblServicioEmpleado)
                                        .addComponent(jCbxEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPnlEmpleadosLayout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addGroup(jPnlEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLblEmpleadoNombre)
                                        .addComponent(jBtnEmpleadoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                        .addComponent(jTxtEmpleadoNombre))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnlEmpleadosLayout.setVerticalGroup(
                jPnlEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlEmpleadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLblEmpleadoNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtEmpleadoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnEmpleadoGuardar)
                                .addGroup(jPnlEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPnlEmpleadosLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLblServicioEmpleado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCbxEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPnlEmpleadosLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(59, 59, 59))
        );

        jPnlProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS"));

        jTblProductos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "NOMBRE"
                }
        ));
        jScrollPane2.setViewportView(jTblProductos);

        jLblServicioProducto.setText("SERVICIO");

        jCbxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"db", "rest", "ws"}));
        jCbxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbxProductosActionPerformed(evt);
            }
        });

        jLblProductoNombre.setText("NOMBRE");

        jTxtProductoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtProductoNombreActionPerformed(evt);
            }
        });

        jBtnProductoGuardar.setText("GUARDAR");
        jBtnProductoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnProductoGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlProductosLayout = new javax.swing.GroupLayout(jPnlProductos);
        jPnlProductos.setLayout(jPnlProductosLayout);
        jPnlProductosLayout.setHorizontalGroup(
                jPnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlProductosLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLblServicioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPnlProductosLayout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addGroup(jPnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLblProductoNombre)
                                        .addComponent(jBtnProductoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                        .addComponent(jTxtProductoNombre))
                                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPnlProductosLayout.setVerticalGroup(
                jPnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlProductosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLblProductoNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtProductoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnProductoGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPnlProductosLayout.createSequentialGroup()
                                                .addComponent(jLblServicioProducto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPnlEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jPnlEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jPnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jTxtEmpleadoNombreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTxtProductoNombreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jBtnEmpleadoGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Employee employee = new Employee(jTxtEmpleadoNombre.getText());
        boolean result = employeesServiceSelected.addEmployee(employee);
        if (result) {
            mostrarMensaje("Empleado guardado correctamente");
            listarTablaEmpleados();
        } else {
            mostrarMensaje("Error al guardar el empleado");
        }
    }

    private void jBtnProductoGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Product product = new Product(jTxtProductoNombre.getText());
        boolean result = productsServiceSelected.addProduct(product);
        if (result) {
            mostrarMensaje("Producto guardado correctamente");
            listarTablaProductos();
        } else {
            mostrarMensaje("Error al guardar el producto");
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void jCbxEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        listarTablaEmpleados();
    }


    private void jCbxProductosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        listarTablaProductos();
    }

    private void llenarTablaProducts(List<Product> products) {
        limpiarTablaProducts();
        DefaultTableModel model = (DefaultTableModel) jTblProductos.getModel();
        for (Product product : products) {
            model.addRow(new Object[]{product.getId(), product.getName()});
        }
    }

    private void limpiarTablaProducts() {
        DefaultTableModel model = (DefaultTableModel) jTblProductos.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void llenarTablaEmployees(List<Employee> employees) {
        limpiarTablaEmployees();
        DefaultTableModel model = (DefaultTableModel) jTblEmpleados.getModel();
        for (Employee employee : employees) {
            model.addRow(new Object[]{employee.getId(), employee.getName()});
        }
    }

    private void limpiarTablaEmployees() {
        DefaultTableModel model = (DefaultTableModel) jTblEmpleados.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jBtnEmpleadoGuardar;
    private javax.swing.JButton jBtnProductoGuardar;
    private javax.swing.JComboBox<String> jCbxEmpleados;
    private javax.swing.JComboBox<String> jCbxProductos;
    private javax.swing.JLabel jLblEmpleadoNombre;
    private javax.swing.JLabel jLblProductoNombre;
    private javax.swing.JLabel jLblServicioEmpleado;
    private javax.swing.JLabel jLblServicioProducto;
    private javax.swing.JPanel jPnlEmpleados;
    private javax.swing.JPanel jPnlProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblEmpleados;
    private javax.swing.JTable jTblProductos;
    private javax.swing.JTextField jTxtEmpleadoNombre;
    private javax.swing.JTextField jTxtProductoNombre;
    // End of variables declaration
}
