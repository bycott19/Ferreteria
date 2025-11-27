package Vista;

import Modelo.Producto;
import Controlador.ControladorFerreteria;

public class PantallaIngresaProducto extends javax.swing.JFrame {

    public PantallaIngresaProducto() {
        initComponents();
        this.setLocationRelativeTo(null); // <--- CENTRAR VENTANA
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ingresaMarca = new javax.swing.JTextField();
        ingresaPrecio = new javax.swing.JTextField();
        ingresaDescripcion = new javax.swing.JTextField();
        ingresaCodigo = new javax.swing.JTextField();
        botonIngresaProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("INGRESANDO NUEVO PRODUCTO AL SISTEMA");
        jLabel4.setText("Precio:");
        jLabel5.setText("Codigo:");
        jLabel6.setText("Descripción:");
        jLabel7.setText("Marca:");

        botonIngresaProducto.setText("INGRESAR");
        botonIngresaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresaProductoActionPerformed(evt);
            }
        });

        // Configuración básica del layout (mantén la tuya original si prefieres)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(botonIngresaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(ingresaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ingresaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ingresaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ingresaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(ingresaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(ingresaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(ingresaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(ingresaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(botonIngresaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    private void botonIngresaProductoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String codigoString = ingresaCodigo.getText();
            String marca = ingresaMarca.getText();
            String descripcion = ingresaDescripcion.getText();
            String precioString = ingresaPrecio.getText();

            int codigo = Integer.parseInt(codigoString);
            int precio = Integer.parseInt(precioString);

            Producto producto = new Producto(codigo, marca, descripcion, precio);
            ControladorFerreteria.getInstance().creaProducto(producto);

            javax.swing.JOptionPane.showMessageDialog(this, "Producto creado con éxito");

            new PantallaMenu().setVisible(true);
            this.dispose();
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Código y Precio deben ser números");
        }
    }

    // Variables
    private javax.swing.JButton botonIngresaProducto;
    private javax.swing.JTextField ingresaCodigo;
    private javax.swing.JTextField ingresaDescripcion;
    private javax.swing.JTextField ingresaMarca;
    private javax.swing.JTextField ingresaPrecio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
}