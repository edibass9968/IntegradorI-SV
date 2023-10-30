package modelo1;

public class Mascota {
    
    private int idMascota;
    private String nombre;
    private String genero;
    private String raza;
    private int idCliente;
    private int idTipoMas;

    public Mascota() {
    }

    public Mascota(String nombre, String genero, String raza, int idCliente, int idTipoMas) {
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.idCliente = idCliente;
        this.idTipoMas = idTipoMas;
    }

    public Mascota(int idMascota, String nombre, String genero, String raza, int idCliente, int idTipoMas) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.idCliente = idCliente;
        this.idTipoMas = idTipoMas;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoMas() {
        return idTipoMas;
    }

    public void setIdTipoMas(int idTipoMas) {
        this.idTipoMas = idTipoMas;
    }
    
    
    
}
