package modelo1;

public class Venta {
    
    private int idVenta;
    private String fecha;
    private double totalVenta;
    private int idPersonal;
    private int idCliente;

    public Venta() {
    }

    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(String fecha, double totalVenta, int idPersonal, int idCliente) {
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.idPersonal = idPersonal;
        this.idCliente = idCliente;
    }

    public Venta(int idVenta, String fecha, double totalVenta, int idPersonal, int idCliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.idPersonal = idPersonal;
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
