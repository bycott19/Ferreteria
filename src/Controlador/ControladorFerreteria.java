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
    private static ControladorFerreteria instance = null;
    private ControladorFerreteria(){}
    public static ControladorFerreteria getInstance() {
        if(instance==null){
            instance = new ControladorFerreteria();
        }
        return instance;
    }
    static ArrayList<Cliente> clientes = new ArrayList();
    static ArrayList <Producto> productos = new ArrayList();
    static ArrayList <Venta> ventas = new ArrayList();

    public void creaCliente(Cliente nuevo){
        clientes.add(nuevo);
    }
    public void creaProducto(Producto nuevo){
        productos.add(nuevo);
    }
    public void crearVenta(Venta nueva){
        ventas.add(nueva);
    }

    public Venta[] listaVentas(){
        Venta[] listaVentas = new Venta[ventas.size()];
        int i=0;
        for(Venta lasVentas : ventas){
            listaVentas[i] = lasVentas;
            i++;
        }
        return listaVentas;
    }
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
            Scanner sc3= new Scanner(new File("ventas.txt"));
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
            while(sc3.hasNextLine()){
                String linea = sc3.nextLine();
                String[] datos = linea.split(";");
                ArrayList<DetalleVenta> detalles = new ArrayList<>();
                for(int i = 3; i<datos.length; i += 2){
                    detalles.add(new DetalleVenta(Integer.parseInt(datos[i]), buscarProducto(Integer.parseInt(datos[i+1]))));
                }

                ventas.add(new Venta(Integer.parseInt(datos[0]), buscarCliente(datos[1]), datos[2], detalles));
            }

            System.out.println("DATOS CARGADOS CON EXITO!!!");
        }catch (Exception e){
            System.out.println("NO SE HAN PODIDO CARGAR LOS DATOS");
        }
    }
    public void guardarDatos(){
        try{
            FileWriter writer1 = new FileWriter(new File("clientes.txt"));
            FileWriter writer2 = new FileWriter(new File("productos.txt"));
            FileWriter writer3 = new FileWriter(new File("ventas.txt"));
            for(Cliente cliente : clientes) {
                writer1.write(cliente.getRut() + ";" + cliente.getNombre() + ";" + cliente.getDireccion() + ";" + cliente.getTelefono() + "\n");
            }
            for(Producto producto : productos){
                writer2.write(producto.getCodigo()+";"+ producto.getMarca()+";"+producto.getDescripcion()+";"+producto.getPrecio()+"\n");
            }
            for(Venta venta : ventas){
                writer3.write(venta.getCodigoVenta() + ";" + venta.getCliente().getRut() + ";" + venta.getFecha());
                for(DetalleVenta detalle : venta.getDetalleVentas()){
                    writer3.write(";" + detalle.getCantidad() + ";" + detalle.getElProducto().getCodigo());
                }
                writer3.write("\n");
            }

            System.out.println("DATOS GUARDADOS CON EXITO!!!! ");
            writer1.close();
            writer2.close();
            writer3.close();
        }catch (IOException e){
            System.out.println("No se han podido guardar los Datos");
        }
    }
}
