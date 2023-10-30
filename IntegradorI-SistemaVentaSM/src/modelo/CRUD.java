package modelo;

import java.util.List;


public interface CRUD {
    public List Listar();
 
    public int add(Object[] o);
    public int Actualizar(Object[] o);
    public void Eliminar(int id);
  
    
}
