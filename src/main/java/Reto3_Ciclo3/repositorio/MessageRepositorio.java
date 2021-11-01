
package Reto3_Ciclo3.repositorio;

import Reto3_Ciclo3.interfaces.interfaceMessage;
import Reto3_Ciclo3.modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author solecito
 */
@Repository
public class MessageRepositorio {
  @Autowired
    private interfaceMessage crud;
    
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    public Optional <Message> getMessage(int id){
        return crud.findById(id);
    }
    
    public Message save(Message message){
        return crud.save(message);
    } 
    public void delete(Message message){
        crud.delete(message);
    }  
}
