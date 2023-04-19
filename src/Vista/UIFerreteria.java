package Vista;

import Controlador.ControladorFerreteria;
import Modelo.Cliente;
import Modelo.Producto;

import java.util.*;
public class UIFerreteria {

    /* private final Scanner sc;
    private UIFerreteria(){
        sc = new Scanner(System.in);
    }*/
    static Scanner sc= new Scanner(System.in);
    private static UIFerreteria instance = null;
    public static UIFerreteria getInstance() {
        if (instance==null){
            instance = new UIFerreteria();
        }
        return instance;
    }
    public static void CrearCliente(){
        System.out.println("Creando un nuevo cliente");
        System.out.print("Rut: ");
        String rut=sc.next();
        System.out.print("Nombre: ");
        String nombre=sc.next();
        System.out.print("Dirección: ");
        String direccion=sc.next();
        System.out.print("Telefono: ");
        String telefono=sc.next();

        Cliente nuevo = new Cliente(rut, nombre, direccion, telefono);
    }
    public static void CrearProducto(){
        System.out.println("Creando un nuevo producto");
        System.out.print("Codigo: " );
        long cod=sc.nextLong();
        System.out.println("Marca: ");
        String marca=sc.next();
        System.out.print("Descripción: ");
        String descripcion= sc.next();
        System.out.print("Precio: $");
        int precio= sc.nextInt();
        Producto nuevoProducto = new Producto(cod, marca, descripcion, precio);
    }

    private void ListaProductos() {
    }

    public static void ListaClientes(){}

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
            System.out.println("5.- Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > 5) {
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
                        System.out.println("Adios!!");
                        break;
                }
            }
        }while (opcion != 5);
    }


}
