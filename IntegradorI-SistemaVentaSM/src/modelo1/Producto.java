package modelo1;



public class Producto {
    private int id;
    private String nom;
    private int stock;
    private Double precio;

    public Producto() {
    }    

    public Producto(String nom, int stock, Double precio) {
        this.nom = nom;
        this.stock = stock;
        this.precio = precio;
    }

    public Producto(int id, String nom,int stock, Double precio) {
        this.id = id;
        this.nom = nom;
        this.stock = stock;
        this.precio = precio;
       
       
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
     public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
 
}
