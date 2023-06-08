package Modelo;
public class DetalleVenta {
    private int cantidadCompra;
    private Producto elProducto;

    public DetalleVenta(int cantidadCompra, Producto elProducto){
        this.cantidadCompra=cantidadCompra;
        this.elProducto=elProducto;
    }
    public int getCantidad() {
        return cantidadCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidadCompra = cantidad;
    }

    public Producto getElProducto() {
        return elProducto;
    }

    public void setElProducto(Producto elProducto) {
        this.elProducto = elProducto;
    }
}
