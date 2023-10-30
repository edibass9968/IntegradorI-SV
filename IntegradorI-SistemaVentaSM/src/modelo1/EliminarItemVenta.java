package modelo1;

public class EliminarItemVenta {
    
    private int sufijo;
    private String tipo;

    public EliminarItemVenta(int sufijo, String tipo) {
        this.sufijo = sufijo;
        this.tipo = tipo;
    }

    public EliminarItemVenta() {
    }

    public int getSufijo() {
        return sufijo;
    }

    public void setSufijo(int sufijo) {
        this.sufijo = sufijo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
