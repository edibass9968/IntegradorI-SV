package modelo1;

public class DetalleServicio {
    private int idVenta;
    private int idMascota;
    private int idServicio;

    public DetalleServicio() {
    }

    public DetalleServicio(int idVenta) {
        this.idVenta = idVenta;
    }

    public DetalleServicio(int idVenta, int idMascota, int idServicio) {
        this.idVenta = idVenta;
        this.idMascota = idMascota;
        this.idServicio = idServicio;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    
    
}
