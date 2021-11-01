
package Reto3_Ciclo3.repositorio;

import Reto3_Ciclo3.interfaces.interfaceCategoria;
import Reto3_Ciclo3.modelo.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author solecito
 */
@Repository
public class CategoriaRepositorio {
    
     @Autowired
    private interfaceCategoria crud;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    public Optional <Categoria> getCategoria(int id){
        return crud.findById(id);
    }
    
    public Categoria save(Categoria category){
        return crud.save(category);
    }
    public void delete(Categoria category){
         crud.delete(category);
}
}