package Controlador;
import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Venta;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ControladorFerreteria {
    static ArrayList <Cliente> clientes = new ArrayList();
    static ArrayList <Producto> productos = new ArrayList();
    static ArrayList <Venta> ventas = new ArrayList();
    private static ControladorFerreteria instance = null;

    private ControladorFerreteria(){

    }
    public static ControladorFerreteria getInstance() {
        if(instance==null){
            instance = new ControladorFerreteria();
        }
        return instance;
    }

    public void creaCliente(Cliente nuevo){
        clientes.add(nuevo);
    }
    public void creaProducto(Producto nuevo){
        productos.add(nuevo);
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


    //METODOS DE LA SEGUNDA PARTE
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
    public void crearVenta(Venta nueva){
        ventas.add(nueva);
    }
    public  Venta[] listarVentas(){
        Venta[] listaVentas = new Venta[ventas.size()];
        int i=0;
        for(Venta misVentas : ventas){
            listaVentas[i] = misVentas;
            i++;
        }
        return listaVentas;
    }
    public static Object CantidadProductos(int codigo, int cantidad){
        int total=0;
        for(Producto misProductos: productos){
            if(cantidad>misProductos.getCantidad()){
                return null;
            }
            if(misProductos.getCodigo() == codigo){
                misProductos.setCantidad(misProductos.getCantidad()-cantidad);
            }
        }
        return 0;
    }
    public static int totalCompra(int codigo, int cantidad){
        int total=0;
        for(Producto misProductos : productos){
            if(misProductos.getCodigo() == codigo){
                total+=(misProductos.getPrecio()*cantidad);
            }
        }
        return total;
    }
    public void leerProductos(){
        try{
            Scanner sc= new Scanner(new File("productos.txt"));
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] datos= linea.split(";");
                productos.add(new Producto(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4])));
            }
        }catch (Exception e){
            System.out.println("No se ha  podido leer los datos de productos");
        }
    }
    public void leerClientes(){
        try{
            Scanner sc = new Scanner(new File("clientes.txt"));
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] datos = linea.split(";");
                clientes.add(new Cliente(datos[0], datos[1], datos[2], datos[3]));
            }
        }catch (Exception e){
            System.out.println("No se han podido leer los datos de clientes.");
        }
    }
    public void guardarClientes(){
        try{
            FileWriter writer = new FileWriter(new File("clientes.txt"));

            for(Cliente cliente : clientes) {
                writer.write(cliente.getRut() + ";" + cliente.getNombre() + ";" + cliente.getDireccion() + ";" + cliente.getTelefono() + "\n");
            }
            System.out.println("Los clientes se han guardado con exito!!!! ");
            writer.close();
        }catch (Exception e){
            System.out.println("No se han podido guardar los clientes.");
        }
    }
    public void guardarProductos(){
        try{
            FileWriter writer = new FileWriter(new File("productos.txt"));

            for(Producto producto : productos){
                writer.write(producto.getCodigo()+";"+ producto.getMarca()+";"+producto.getDescripcion()+";"+producto.getPrecio()+";"+producto.getCantidad()+"\n");
            }
            System.out.println("Los productos se han guardado con exito!!!!");
            writer.close();
        }catch (Exception e){
            System.out.println("No se han podido guardar los productos");
        }
    }
    public void guardarVentas(){
        try{
            FileWriter writer = new FileWriter(new File("ventas.txt"));

            for(Venta venta : ventas) {
                writer.write(venta.getCodigoVenta() + ";" + venta.getCliente().getRut() + ";" + venta.getFecha());
                for(Producto producto : venta.getProductos()){
                    writer.write(";" + producto.getCodigo());
                }
                writer.write("\n");
            }

            writer.close();
        }catch (Exception e){
            System.out.println("No se han podido guardar las ventas.");
        }
    }

    public void leerVentas(){
        try{
            Scanner sc = new Scanner(new File("ventas.txt"));
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] datos = linea.split(";");
                ArrayList<Producto> productosVenta = new ArrayList<>();
                for(int i = 3; i<datos.length; i++){
                    productosVenta.add(buscarProducto(Integer.parseInt(datos[i])));
                }
                ventas.add(new Venta(Integer.parseInt(datos[0]), buscarCliente(datos[1]), datos[2], productosVenta));
            }
        }catch (Exception e){
            System.out.println("No se han podido leer los datos de ventas.");
        }
    }

}

