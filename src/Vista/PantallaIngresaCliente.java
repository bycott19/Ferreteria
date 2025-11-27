package Vista;

import Controlador.ControladorFerreteria;
import Modelo.Cliente;
import javax.swing.JOptionPane;

public class PantallaIngresaCliente extends javax.swing.JFrame {

    // Declaración de variables
    private javax.swing.JButton botonIngresarCliente;
    private javax.swing.JButton botonCancelar; // Agregué un botón cancelar por comodidad
    private javax.swing.JTextField ingresaDireccion;
    private javax.swing.JTextField ingresaNombre;
    private javax.swing.JTextField ingresaRut;
    private javax.swing.JTextField ingresaTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelRut;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel1;

    public PantallaIngresaCliente() {
        initComponents();
        this.setLocationRelativeTo(null); // Centrar en pantalla
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelRut = new javax.swing.JLabel();
        ingresaRut = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        ingresaNombre = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        ingresaDireccion = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        ingresaTelefono = new javax.swing.JTextField();
        botonIngresarCliente = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Cliente");

        // Configuración de textos y fuentes
        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("NUEVO CLIENTE");

        jLabelRut.setText("RUT:");
        jLabelNombre.setText("Nombre:");
        jLabelDireccion.setText("Dirección:");
        jLabelTelefono.setText("Teléfono:");

        botonIngresarCliente.setText("Guardar Cliente");
        botonIngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarClienteActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new PantallaMenu().setVisible(true);
                dispose();
            }
        });

        // --- INICIO DEL DISEÑO (LAYOUT) ---
        // Esto es lo que faltaba para que la ventana tenga tamaño
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelNombre)
                                                        .addComponent(jLabelRut)
                                                        .addComponent(jLabelDireccion)
                                                        .addComponent(jLabelTelefono))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ingresaRut)
                                                        .addComponent(ingresaNombre)
                                                        .addComponent(ingresaDireccion)
                                                        .addComponent(ingresaTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabelTitulo)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRut)
                                        .addComponent(ingresaRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNombre)
                                        .addComponent(ingresaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDireccion)
                                        .addComponent(ingresaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTelefono)
                                        .addComponent(ingresaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonIngresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack(); // Ajusta la ventana al tamaño de los componentes
    }

    private void botonIngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        String rut = ingresaRut.getText();
        String nombre = ingresaNombre.getText();
        String direccion = ingresaDireccion.getText();
        String telefono = ingresaTelefono.getText();

        // Validación simple
        if(rut.trim().isEmpty() || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese al menos RUT y Nombre.");
            return;
        }

        // Verificar si ya existe
        if(ControladorFerreteria.getInstance().buscarCliente(rut) != null){
            JOptionPane.showMessageDialog(this, "El cliente con este RUT ya existe.");
            return;
        }

        Cliente cliente = new Cliente(rut, nombre, direccion, telefono);
        ControladorFerreteria.getInstance().creaCliente(cliente);

        JOptionPane.showMessageDialog(this, "Cliente creado con éxito!!!!");

        new PantallaMenu().setVisible(true);
        this.dispose();
    }
}