package Vista;

import Controlador.ControladorFerreteria;
import Modelo.DetalleVenta;
import Modelo.Venta;
import javax.swing.table.DefaultTableModel;

public class PantallaListarVentas extends javax.swing.JFrame {

    private javax.swing.JTable tablaVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel titulo;

    public PantallaListarVentas() {
        initComponents();
        cargarDatos();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de Ventas");

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setText("HISTORIAL DE VENTAS");
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] { "N° Venta", "RUT Cliente", "Fecha", "Monto Total" }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(evt -> {
            new PantallaMenu().setVisible(true);
            this.dispose();
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(titulo)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaVentas.getModel();
        modelo.setRowCount(0);

        Venta[] ventas = ControladorFerreteria.getInstance().listaVentas();

        if (ventas != null) {
            for (Venta v : ventas) {
                // Calcular total de esta venta
                int totalVenta = 0;
                for (DetalleVenta dv : v.getDetalleVenta()) {
                    totalVenta += dv.getCantidadCompra() * dv.getProducto().getPrecio();
                }
                // Sumar IVA como en tu lógica original
                double totalConIVA = totalVenta * 1.19;

                modelo.addRow(new Object[]{
                        v.getCodigoVenta(),
                        v.getCliente().getRut(),
                        v.getFecha(),
                        "$" + Math.round(totalConIVA)
                });
            }
        }
    }
}