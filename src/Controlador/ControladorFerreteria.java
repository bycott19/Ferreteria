package Controlador;

import Modelo.Cliente;
import Modelo.Producto;

import java.util.ArrayList;
public class ControladorFerreteria {
    ArrayList <Cliente> clientes = new ArrayList();
    ArrayList <Producto> productos = new ArrayList();


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

}
