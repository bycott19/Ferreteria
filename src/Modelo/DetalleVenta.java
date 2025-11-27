package Modelo;

public class DetalleVenta {

    private int cantidadCompra;
    private Producto producto;

    public DetalleVenta(int cantidadCompra, Producto producto) {
        this.cantidadCompra = cantidadCompra;
        this.producto = producto;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
