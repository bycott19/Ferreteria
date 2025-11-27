package Vista;

import Controlador.ControladorFerreteria;
import Modelo.Cliente;
import javax.swing.table.DefaultTableModel;

public class PantallaListarClientes extends javax.swing.JFrame {

    // Componentes visuales
    private javax.swing.JTable tablaClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel titulo;

    public PantallaListarClientes() {
        initComponents();
        cargarDatos(); // Cargar los datos al iniciar la ventana
        this.setLocationRelativeTo(null); // Centrar ventana
    }

    private void initComponents() {
        // Inicialización de componentes
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Clientes");

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setText("LISTADO DE CLIENTES");
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Configuración de la tabla
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] { "RUT", "Nombre", "Dirección", "Teléfono" }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        btnVolver.setText("Volver al Menú");
        btnVolver.addActionListener(evt -> {
            new PantallaMenu().setVisible(true);
            this.dispose();
        });

        // Diseño (Layout) manual básico
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
                                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        DefaultTableModel modelo = (DefaultTableModel) tablaClientes.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        // Obtener datos del controlador
        Cliente[] clientes = ControladorFerreteria.getInstance().listaClientes();

        if (clientes != null) {
            for (Cliente c : clientes) {
                modelo.addRow(new Object[]{
                        c.getRut(),
                        c.getNombre(),
                        c.getDireccion(),
                        c.getTelefono()
                });
            }
        }
    }
}