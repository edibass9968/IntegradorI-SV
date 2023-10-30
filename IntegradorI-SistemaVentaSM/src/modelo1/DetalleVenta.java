package modelo1;

public class DetalleVenta {
    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double monto;

    public DetalleVenta() {
    }

    public DetalleVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public DetalleVenta(int idVenta, int idProducto, int cantidad, double monto) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
}
