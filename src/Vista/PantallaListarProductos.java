package Vista;

import Controlador.ControladorFerreteria;
import Modelo.Producto;
import javax.swing.table.DefaultTableModel;

public class PantallaListarProductos extends javax.swing.JFrame {

    private javax.swing.JTable tablaProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel titulo;

    public PantallaListarProductos() {
        initComponents();
        cargarDatos();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Productos");

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setText("LISTADO DE PRODUCTOS");
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] { "Código", "Marca", "Descripción", "Precio" }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

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
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
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
        DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
        modelo.setRowCount(0);

        Producto[] productos = ControladorFerreteria.getInstance().listaProductos();

        if (productos != null) {
            for (Producto p : productos) {
                modelo.addRow(new Object[]{
                        p.getCodigo(),
                        p.getMarca(),
                        p.getDescripcion(),
                        "$" + p.getPrecio()
                });
            }
        }
    }
}