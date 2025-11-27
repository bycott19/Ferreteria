package Vista;

import Controlador.ControladorFerreteria;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Venta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PantallaIngresaVenta extends javax.swing.JFrame {

    // Carrito temporal
    private ArrayList<DetalleVenta> carritoCompras;
    private DefaultTableModel modeloTabla;

    public PantallaIngresaVenta() {
        initComponents();
        carritoCompras = new ArrayList<>();
        inicializarTabla();
        this.setLocationRelativeTo(null);
    }

    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Subtotal");
        tablaDetalles.setModel(modeloTabla);
    }

    private void initComponents() {
        // Componentes
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRutCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();

        // Panel para agregar producto
        panelProducto = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();

        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Venta");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("NUEVA VENTA");

        jLabel3.setText("RUT Cliente:");
        jLabel4.setText("Cód. Venta:");
        jLabel10.setText("Fecha:");

        panelProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Producto"));
        jLabel11.setText("Cód. Producto:");
        jLabel12.setText("Cantidad:");

        btnAgregar.setText("Agregar al Carrito");
        btnAgregar.addActionListener(evt -> agregarProducto());

        // Layout del Panel de Producto
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAgregar))
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(tablaDetalles);

        btnFinalizar.setText("FINALIZAR VENTA");
        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnFinalizar.addActionListener(evt -> guardarVenta());

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(evt -> {
            new PantallaMenu().setVisible(true);
            this.dispose();
        });

        // Layout Principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtRutCliente)
                                                        .addComponent(txtCodVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1)
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnCancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancelar))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void agregarProducto() {
        try {
            int cod = Integer.parseInt(txtCodProducto.getText());
            int cant = Integer.parseInt(txtCantidad.getText());

            Producto p = ControladorFerreteria.getInstance().buscarProducto(cod);

            if (p != null) {
                // Crear detalle
                DetalleVenta detalle = new DetalleVenta(cant, p);
                carritoCompras.add(detalle);

                // Agregar a tabla visual
                modeloTabla.addRow(new Object[]{
                        p.getDescripcion(),
                        p.getPrecio(),
                        cant,
                        p.getPrecio() * cant
                });

                // Limpiar campos de producto
                txtCodProducto.setText("");
                txtCantidad.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Producto no existe");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos");
        }
    }

    private void guardarVenta() {
        if (carritoCompras.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío");
            return;
        }

        String rut = txtRutCliente.getText();
        String fecha = txtFecha.getText();

        try {
            int codVenta = Integer.parseInt(txtCodVenta.getText());
            Cliente cli = ControladorFerreteria.getInstance().buscarCliente(rut);

            if (cli != null) {
                // Crear Venta Final
                Venta venta = new Venta(codVenta, cli, fecha, carritoCompras);
                ControladorFerreteria.getInstance().creaVenta(venta);

                JOptionPane.showMessageDialog(this, "Venta Registrada con Éxito");
                new PantallaMenu().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado. Verifique RUT.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código de venta debe ser numérico");
        }
    }

    // Variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtCodVenta;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtRutCliente;
}