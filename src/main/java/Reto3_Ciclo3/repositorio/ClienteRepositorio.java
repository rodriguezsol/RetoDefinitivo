
package Reto3_Ciclo3.repositorio;

import Reto3_Ciclo3.interfaces.interfaceCliente;
import Reto3_Ciclo3.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author solecito
 */
@Repository
public class ClienteRepositorio {
  @Autowired
    private interfaceCliente crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    public Optional <Client> getClient(int id){
        return crud.findById(id);
    }
    
    public Client save(Client client){
        return crud.save(client);
    } 
    public  void delete(Client client){
        crud.delete(client);
}
}