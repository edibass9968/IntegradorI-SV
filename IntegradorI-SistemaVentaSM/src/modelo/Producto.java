/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JOSE
 */
public class Producto {
    int id;
    String nom;
    int stock;
    double precio;
    
     
   

    public Producto() {
    }

    public Producto(int id, String nom,int stock, double precio) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    
}



