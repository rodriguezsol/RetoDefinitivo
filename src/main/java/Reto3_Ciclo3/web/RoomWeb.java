
package Reto3_Ciclo3.web;

import Reto3_Ciclo3.sevicio.serviciosRoom;
import Reto3_Ciclo3.modelo.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author solecito
 */
@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RoomWeb {
    
    @Autowired
    private serviciosRoom servicios;
    @GetMapping("/all")
    public List <Room> getRooms(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int idRoom) {
        return servicios.getRoom(idRoom);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room) {
        return servicios.save(room);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room) {
        return servicios.update(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idRoom) {
        return servicios.deleteRoom(idRoom); 
    
}
}