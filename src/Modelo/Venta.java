package Modelo;

import java.util.ArrayList;

public class Venta {

    private int codigoVenta;
    private Cliente clientes;
    private ArrayList<Producto> productos = new ArrayList<>();
    private String fecha;

    public Venta(int codigoVenta, Cliente clientes, ArrayList<Producto> productos1, String fecha) {
        this.codigoVenta = codigoVenta;
        this.clientes = clientes;
        ArrayList<Producto> producto1= this.productos;
        this.fecha = fecha;
    }
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
    public Cliente getClientes() {
        return clientes;
    }
    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
