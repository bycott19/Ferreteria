package Controlador;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Venta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorFerreteria {
    static ArrayList <Cliente> clientes = new ArrayList();
    static ArrayList <Producto> productos = new ArrayList();
    static ArrayList <Venta> ventas = new ArrayList();
    static ArrayList <DetalleVenta> detalle = new ArrayList<>();
    private static ControladorFerreteria instance = null;
    private ControladorFerreteria(){}
    public static ControladorFerreteria getInstance() {
        if(instance==null){
            instance = new ControladorFerreteria();
        }
        return instance;
    }

    //Crear ArrayList
    public void creaCliente(Cliente nuevo){
        clientes.add(nuevo);
    }
    public void creaProducto(Producto nuevo){
        productos.add(nuevo);
    }
    public void crearVenta(Venta nueva){ventas.add(nueva);}
    public void creaDetalle(DetalleVenta nuevo){detalle.add(nuevo);
    }

    //Listar ArrayList
    public Cliente[] listaClientes(){
        Cliente[] listaClientes = new Cliente[clientes.size()];
        int i = 0;
        for(Cliente cliente : clientes){
            listaClientes[i] = cliente;
            i++;
        }
        return listaClientes;
    }

    public Producto[] listaProductos(){
        Producto[] listaProductos = new Producto[productos.size()];
        int i = 0;
        for(Producto producto : productos){
            listaProductos[i] = producto;
            i++;
        }
        return listaProductos;
    }
    public void listarVentas(){
        for(Venta misVentasClientes: ventas){
            misVentasClientes.dibujaFactura();
            listarDetalle();
        }
    }
    public void listarDetalle(){
        int acumulado=0;
        for(DetalleVenta detalle : detalle){
            Producto auxiliar = detalle.getElProducto();
            int totalLinea =  auxiliar.getPrecio() * detalle.getCantidad();
            System.out.println("Cantidad: "+detalle.getCantidad()+"  "+auxiliar.getDescripcion()+"   total:"+totalLinea);
            acumulado=acumulado+totalLinea;
        }
        System.out.println();
        System.out.println("Total NETO: "+acumulado);
        double iva = acumulado* 0.19;
        System.out.println("IVA: "+iva);
        System.out.println("TOTAL : $"+(acumulado+iva));
        System.out.println();
    }

    //Buscar o ver si existe
    public static Cliente buscarCliente(String rut){
        for(Cliente misClientes : clientes){
            if(misClientes.getRut().equalsIgnoreCase(rut)){
                return misClientes;
            }
        }
        return null;
    }
    public static Producto buscarProducto(int codProducto){
        for(Producto misProductos : productos) {
            if(misProductos.getCodigo()==codProducto){
                return misProductos;
            }
        }
        return null;
    }
    public static ArrayList<Cliente> existeCliente() {
        if (clientes.size() != 0) {
            return clientes;
        }

        return null;
    }
    public static ArrayList<Producto> existeProducto(){
        if(productos.size()!=0){
            return productos;
        }
        return null;
    }

    //Archivos de texto
    public void leerDatos(){
        try{
            Scanner sc1 = new Scanner(new File("clientes.txt"));
            Scanner sc2= new Scanner(new File("productos.txt"));
            while (sc1.hasNextLine()){
                String linea = sc1.nextLine();
                String[] datos = linea.split(";");
                clientes.add(new Cliente(datos[0], datos[1], datos[2], datos[3]));
            }
            while (sc2.hasNextLine()){
                String linea = sc2.nextLine();
                String[] datos= linea.split(";");
                productos.add(new Producto(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3])));
            }
            System.out.println("DATOS CARGADOS CON EXITO!!!");
        }catch (Exception e){
            System.out.println("NO SE HAN PODIDO CARGAR LOS DATOS");
        }
    }
    public void guardarDatos(){
        try{
            File archivo1 = new File("clientes.txt");
            FileWriter writer1 = new FileWriter(archivo1);
            FileWriter writer2 = new FileWriter(new File("productos.txt"));
            for(Producto producto : productos){
                writer2.write(producto.getCodigo()+";"+ producto.getMarca()+";"+producto.getDescripcion()+";"+producto.getPrecio()+"\n");
            }
            for(Cliente cliente : clientes) {
                writer1.write(cliente.getRut() + ";" + cliente.getNombre() + ";" + cliente.getDireccion() + ";" + cliente.getTelefono() + "\n");
            }
            System.out.println("DATOS GUARDADOS CON EXITO!!!! ");
            writer1.close();
            writer2.close();
        }catch (IOException e){
            System.out.println("No se han podido guardad los Datos");
        }
    }
}

