
package pe.edu.dao;

import java.util.LinkedList;

/**
 *
 * @author tokiro
 */
public interface DAO<T> {
    
    public T ver(String id);
    public LinkedList<T> listar();
    public void nuevo(T obj);
    public void eliminar(String id);
    public void editar(T obj);
    public String obtenerUsuarioIdPorCorreo(String correo);
    
}
