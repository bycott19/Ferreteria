package Controlador;
import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Venta;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
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
    public static ArrayList<Cliente> buscarCliente(String rut){
        for(Cliente misClientes:clientes){
            if(misClientes.getRut().equalsIgnoreCase(rut)){
                return clientes;
            }
        }
        return null;
    }
    public static ArrayList<Producto> buscarProducto(int codProducto){
        for(Producto misProductos:productos) {
            if(misProductos.getCodigo()==codProducto){
                return productos;
            }
        }
        return null;
    }
    public static ArrayList<Cliente> existeCliente() {
        for (Cliente existen : clientes) {
            if (clientes.size()!=0) {
                return clientes;
            }
        }
        return null;
    }
    public static ArrayList<Producto> existeProducto(){
        for(Producto existe : productos){
            if(productos.size()!=0){
                return productos;
            }
        }
        return null;
    }
    public void ingresarVenta(Venta nueva){
        ventas.add(nueva);
    }
    public void listarVentas(){

    }


}
