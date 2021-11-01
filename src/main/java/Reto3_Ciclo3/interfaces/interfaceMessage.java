
package Reto3_Ciclo3.interfaces;


import Reto3_Ciclo3.modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author solecito
 */
public interface interfaceMessage extends CrudRepository<Message,Integer> {
    
}
