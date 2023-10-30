 package modelo1;


public class TipoMascota {
    
    private int idMascota;
    private String nombre;

    public TipoMascota() {
    }

    public TipoMascota(int idMascota, String nombre) {
        this.idMascota = idMascota;
        this.nombre = nombre;
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
    
    
    
}
