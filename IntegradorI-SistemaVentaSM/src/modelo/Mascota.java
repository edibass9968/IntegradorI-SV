
package modelo;


public class Mascota {
    int id1;
    String nombre;
    String genero;
    String raza;
    int id_clien;
    int id_tipomas;

    public Mascota() {
    }

    public Mascota(int id1, String nombre, String genero, String raza, int id_clien, int id_tipomas) {
        this.id1 = id1;
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.id_clien = id_clien;
        this.id_tipomas = id_tipomas;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
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

    public int getId_clien() {
        return id_clien;
    }

    public void setId_clien(int id_clien) {
        this.id_clien = id_clien;
    }

    public int getId_tipomas() {
        return id_tipomas;
    }

    public void setId_tipomas(int id_tipomas) {
        this.id_tipomas = id_tipomas;
    }
    
}
