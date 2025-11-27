package Vista;

import Controlador.ControladorFerreteria;

public class PantallaMenu extends javax.swing.JFrame {

    public PantallaMenu() {
        initComponents();
        this.setLocationRelativeTo(null); // <--- ESTO CENTRA LA VENTANA
    }

    // ... (El resto del código generado por NetBeans se mantiene igual en initComponents) ...
    // Aquí solo pongo los métodos que modificamos manualmente

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        leerOpcion = new javax.swing.JTextField();
        ingresarOpcion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel1.setText("***** SISTEMA DE FERRETERIA *****");

        jLabel2.setText("MENÚ DE OPCIONES");
        jLabel7.setText("3.- Ingresar nueva venta");
        jLabel8.setText("6.- Listar ventas");
        jLabel9.setText("7.- Cargar Datos");
        jLabel10.setText("8.- Guardar Datos");
        jLabel3.setText("1.- Ingresar nuevo cliente");
        jLabel4.setText("2.- Ingresar nuevo producto");
        jLabel5.setText("4.- Listar clientes");
        jLabel6.setText("5.- Listar productos");
        jLabel11.setText("Ingrese su opción:");

        ingresarOpcion.setText("Ingresar");
        ingresarOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarOpcionActionPerformed(evt);
            }
        });

        // Copia aquí el Layout que ya tienes en tu archivo original o usa el diseñador
        // ... (Layout code) ...
        // Para ahorrar espacio, asumo que el layout ya está generado por tu IDE

        // REEMPLAZA SOLO ESTA PARTE DEL LAYOUT SI LO COPIAS MANUALMENTE:
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabel10)
                                                                .addComponent(jLabel9)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel7))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel11)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(leerOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(ingresarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(leerOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ingresarOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }

    private void ingresarOpcionActionPerformed(java.awt.event.ActionEvent evt) {
        String opcionLeida;
        int opcion = 0;
        try {
            opcionLeida = leerOpcion.getText();
            opcion = Integer.parseInt(opcionLeida);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingrese un número");
            return;
        }

        switch(opcion){
            case 1:
                new PantallaIngresaCliente().setVisible(true);
                this.dispose();
                break;
            case 2:
                new PantallaIngresaProducto().setVisible(true);
                this.dispose();
                break;
            case 3:
                new PantallaIngresaVenta().setVisible(true);
                this.dispose();
                break;
            case 4:
                new PantallaListarClientes().setVisible(true);
                this.dispose();
                break;
            case 5:
                new PantallaListarProductos().setVisible(true);
                this.dispose();
                break;
            case 6:
                new PantallaListarVentas().setVisible(true);
                this.dispose();
                break;
            case 7:
                ControladorFerreteria.getInstance().leerDatos();
                javax.swing.JOptionPane.showMessageDialog(this, "Datos cargados");
                break;
            case 8:
                ControladorFerreteria.getInstance().guardarDatos();
                javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados");
                break;
            case 9:
                System.exit(0);
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(this, "Opción no válida");
        }
    }

    // Variables declaration
    private javax.swing.JButton ingresarOpcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField leerOpcion;
}