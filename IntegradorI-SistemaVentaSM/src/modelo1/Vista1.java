package modelo1;



public class Vista1 {
    
    private int idVenta;
    private String nombre;
    private String apellido;
    private String dni;
    private String fecha;

    public Vista1() {
    }

    public Vista1(int idVenta, String nombre, String apellido, String dni, String fecha) {
        this.idVenta = idVenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha = fecha;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
