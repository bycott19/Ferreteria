package Modelo;

import java.util.ArrayList;

public class Venta {

    private int codigoVenta;
    private Cliente cliente;
    private String fecha;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Venta(int codigoVenta, Cliente cliente, String fecha, ArrayList<Producto> productos1) {
        this.codigoVenta = codigoVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        ArrayList<Producto> producto1= this.productos;
    }
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
