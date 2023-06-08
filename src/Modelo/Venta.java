package Modelo;

import java.util.ArrayList;

public class Venta {

    private int codigoVenta;
    private Cliente cliente;
    private String fecha;
    private ArrayList<DetalleVenta> detalleVentas = new ArrayList<>();

    public Venta(int codigoVenta, Cliente cliente, String fecha, DetalleVenta detalleVentas) {
        this.codigoVenta = codigoVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        ArrayList<DetalleVenta> detalleVentas1= this.detalleVentas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(ArrayList<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
    public void dibujaFactura(){

        System.out.println();
        System.out.println("N° DE FACTURA: "+codigoVenta);
        System.out.println("SE VENDIO A: "+cliente.toString());
        System.out.println("FECHA DE VENTA: "+fecha);
        System.out.println("DETALLE DE LO VENDIDO: ");
        System.out.println();
    }

}
