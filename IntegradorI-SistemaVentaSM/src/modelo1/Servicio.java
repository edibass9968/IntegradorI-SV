package modelo1;



public class Servicio {
    private int id;
    private String descripcion;
    private double precio;
    private int id_tipo;

    public Servicio() {
    }

    public Servicio(String descripcion, double precio, int id_tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.id_tipo = id_tipo;
    }   

    public Servicio(int id, String descripcion, double precio, int id_tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id_tipo = id_tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
}
