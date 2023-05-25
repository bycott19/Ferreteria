package Vista;

import Controlador.ControladorFerreteria;
import Modelo.Cliente;
import Modelo.Producto;

import java.sql.SQLOutput;
import java.util.*;

public class UIFerreteria {
    static Scanner sc= new Scanner(System.in);
    private static UIFerreteria instance = null;
    public static UIFerreteria getInstance() {
        if (instance==null){
            instance = new UIFerreteria();
        }
        return instance;
    }
    /*
    1. Buscar al cliente
    2. verificar que el cliente no existe
    3. Buscar producto
    4. verificar que el producto existe
        cantidad de productos
    5. guardar datos del cliente y de la venta en un arrayList
    6. mostrar ese arrayList
    7.guardar en archivo de texto, los Productos, los clientes y las ventas creadas
    8. 2 opciones de recuperar informacion y mostar informacion
    9.excepciones a todo
    * */


//NUEVO CODIGO
    public void ingresarVenta() {
        System.out.println();
        //VERIFICAR SI EXISTEN DATOS EN EL SISTEMA, Y PARA ESPECIFICAR QUE FALTA
        if (ControladorFerreteria.existeCliente() == null && ControladorFerreteria.existeProducto() == null) {
            System.out.println("No existen Datos en el sistema");
            return;
        } else {
            if (ControladorFerreteria.existeProducto() == null) {
                System.out.println("No existen productos en el sistema");
                return;
            } else {
                if(ControladorFerreteria.existeCliente()==null){
                    System.out.println("No existen clientes en el sistema");
                    return;
                }
            }
        }
        int op;
        System.out.println("Ingrese el rut del cliente");
        String rut=sc.next();
        //PARA VER SI EL RUT QUE INGRESO ESTA EN EL SISTEMA
        while(ControladorFerreteria.buscarCliente(rut)==null){
            System.out.println();
            System.out.println("No existen clientes con ese rut");
            System.out.println("Ingrese de nuevo");
            System.out.print("RUT: ");
            rut=sc.next();
        }
        System.out.println("Ingrese el codigo de la venta");
        int codVenta=sc.nextInt();
        System.out.println("Ingrese la fecha de la venta");
        String fecha=sc.next();

        do{
            System.out.println("Ingrese el codigo del producto");
            int codProducto=sc.nextInt();
            //PARA VER SI EL CODIGO ESTA EN EL SISTEMA
            while(ControladorFerreteria.buscarProducto(codProducto)==null){
                System.out.println();
                System.out.println("No existen productos con ese codigo");
                System.out.println("Ingrese de nuevo: ");
                System.out.print("Codigo producto: ");
                codProducto=sc.nextInt();
            }
            System.out.println("¿Añadir nuevo producto a la compra?");
            System.out.println("1- Si      2-No");
            op=sc.nextInt();
            while(op<1 && op>2){
                System.out.println("Error, opción no valida");
                System.out.println("Ingrese de nuevo");
                op=sc.nextInt();
            }
        }while(op!=2);

    }
    public void listarVentas(){

    }

    //HASTA AQUI
    public void menu(){
        int opcion;
        do {
            System.out.println();
            System.out.println("***** SISTEMA DE FERRETERIA *****");
            System.out.println("** MENU DE OPCIONES **");
            System.out.println("1.- Crear nuevo cliente");
            System.out.println("2.- Crear nuevo producto");
            System.out.println("3.- Listar a todos los clientes");
            System.out.println("4.- Listar todos los productos");

            System.out.println("5.- Ingresar venta");
            System.out.println("6.- Listar ventas");

            System.out.println("7.- Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > 7) {
                System.out.println();
                System.out.println("ERROR... opción invalida");
                System.out.println();
            } else {
                switch (opcion) {
                    case 1:
                        CrearCliente();
                        break;
                    case 2:
                        CrearProducto();
                        break;
                    case 3:
                        ListaClientes();
                        break;
                    case 4:
                        ListaProductos();
                        break;
                    case 5:
                        ingresarVenta();
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println("Adios!!");
                        break;
                }
            }
        }while (opcion != 7);
    }
    public void CrearCliente(){
        System.out.print("Rut: ");
        String rut=sc.next();
        while(ControladorFerreteria.buscarCliente(rut)!=null){
            System.out.println("ERROR. Ya existe un cliente con el mismo rut");
            System.out.print("Rut: ");
            rut=sc.next();
        }
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre=sc.nextLine();
        System.out.print("Dirección: ");
        String direccion=sc.nextLine();
        System.out.print("Telefono: ");
        String telefono=sc.nextLine();
        Cliente nuevo = new Cliente(rut, nombre, direccion, telefono);
        ControladorFerreteria.getInstance().creaCliente(nuevo);
    }
    public void CrearProducto(){

        //AGREGUE LA CANTIDAD COMO ATRIBUTO EN LA CLASE PRODUCTO
        //Y TAMBIEN LA AGREGUE PARA QUE LA INGRESEN AL CREAR EL PRODUCTO Y LA MOSTRE
        //FALTA HACER QUE DISMUNUYA CUANDO SE REALIZA UNA VENTA
        boolean entrar=true;
        System.out.println("Creando un nuevo producto");
        int cod=0;
        String cod2;
        do {
            System.out.print("Codigo: " );
            cod2=sc.next();
            try {
                cod=Integer.parseInt(cod2);
                while(ControladorFerreteria.buscarProducto(cod)!=null){
                    System.out.println("Codigo ya existente");
                    cod2=sc.next();
                    cod=Integer.parseInt(cod2);
                }
                entrar=false;
            } catch (NumberFormatException e) {
                System.out.println("Valor ingresado invalido");
            }
        }while (entrar);
        sc.nextLine();
        System.out.print("Marca: ");
        String marca=sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion= sc.nextLine();

        int prec=0;
        String precio;
        boolean repetir=true;

        do {
            System.out.print("Precio: $");
            precio = sc.nextLine();
            try{
                prec = Integer.parseInt(precio);
                repetir=false;
            } catch (NumberFormatException e){
                System.out.println("precio invalido");
                System.out.println("Ingrese de nuevo");
            }
        } while(repetir);
        System.out.print("Cantidad: ");
        int cantidad=sc.nextInt();
        Producto nuevoProducto = new Producto(cod, marca, descripcion, prec, cantidad);
        ControladorFerreteria.getInstance().creaProducto(nuevoProducto);
    }

    private void ListaProductos(){
        System.out.println();
        System.out.println("***LISTADO DE PRODUCTOS****");
        System.out.printf("%-25s %-25s %-25s %-25s %-25s %n", "Codigo", "MARCA", "DESCRIPCIÓN", "PRECIO", "CANTIDAD");
        Producto[] listaProductos = ControladorFerreteria.getInstance().listaProductos();
        for(int i =0; i<listaProductos.length; i++){
            System.out.printf("%-25d %-25s %-25s %-25d %-25d %n", listaProductos[i].getCodigo(), listaProductos[i].getMarca(), listaProductos[i].getDescripcion(), listaProductos[i].getPrecio(), listaProductos[i].getCantidad());
        }
    }

    public void ListaClientes(){
        System.out.println();
        System.out.println("**** LISTADO DE CLIENTES ****");
        System.out.printf("%-25s %-25s %-35s %-25s %n","RUT", "NOMBRE", "DIRECCIÓN", "TELEFONO");
        Cliente[] listaClientes = ControladorFerreteria.getInstance().listaClientes();
        for(int i = 0; i<listaClientes.length; i++){
            System.out.printf("%-25s %-25s %-35s %-25s %n",listaClientes[i].getRut(), listaClientes[i].getNombre(), listaClientes[i].getDireccion(), listaClientes[i].getTelefono());
        }
    }
}
