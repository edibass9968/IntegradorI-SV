package modelo1;

public class Cliente {
    
    private int idCliente;
    private String nombre;
    private String apellido;
    private String DNI;
    private String direccion;
    private String email;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String DNI, String direccion, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente(int idCliente, String nombre, String apellido, String DNI, String direccion, String email, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
