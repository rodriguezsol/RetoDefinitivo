
package Reto3_Ciclo3.repositorio;

import Reto3_Ciclo3.interfaces.interfaceRoom;
import Reto3_Ciclo3.modelo.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author solecito
 */

@Repository
public class RoomRepositorio {
    @Autowired
    private interfaceRoom crud;
    
    public List<Room> getAll(){
        return (List<Room>) crud.findAll();
    }
    public Optional <Room> getRoom(int id){
        return crud.findById(id);
    }
    
    public Room save(Room room){
        return crud.save(room);
    }
     public void delete(Room room){
        crud.delete(room);
    }
}
