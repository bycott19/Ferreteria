package Modelo;

import java.util.ArrayList;

public class Venta {

    private int codigoVenta;
    private Cliente cliente;
    private String fecha;
    ArrayList<DetalleVenta> detalleVenta = new ArrayList<>();

    public Venta(int codigoVenta, Cliente cliente, String fecha, ArrayList<DetalleVenta> detalleVenta){
        this.codigoVenta = codigoVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.detalleVenta = detalleVenta;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
}
