package Reto3_Ciclo3.sevicio;

import Reto3_Ciclo3.repositorio.RoomRepositorio;
import Reto3_Ciclo3.modelo.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solecito
 */
@Service
public class serviciosRoom {

    @Autowired
    private RoomRepositorio metodosCrud;

    public List<Room> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Room> getRoom(int idRoom) {
        return metodosCrud.getRoom(idRoom);
    }

    public Room save(Room room) {
        if (room.getId() == null) {
            return metodosCrud.save(room);
        } else {
            Optional<Room> evt = metodosCrud.getRoom(room.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(room);
            } else {
                return room;
            }

        }

    }

    public Room update(Room room) {
        if (room.getId() != null) {
            Optional<Room> evento = metodosCrud.getRoom(room.getId());
            if (!evento.isEmpty()) {
                if (room.getName() != null) {
                    evento.get().setName(room.getName());
                }
                if (room.getHotel() != null) {
                    evento.get().setHotel(room.getHotel());
                }
                if (room.getStars() != null) {
                    evento.get().setStars(room.getStars());
                }
                if (room.getDescription() != null) {
                    evento.get().setDescription(room.getDescription());
                }
                if (room.getCategory() != null) {
                    evento.get().setCategory(room.getCategory());
                }
                metodosCrud.save(evento.get());
                return evento.get();
            } else {
                return room;
            }
        } else {
            return room;
        }
    }

    public boolean deleteRoom(int idRoom) {
        Boolean delect = getRoom(idRoom).map(room -> {
            metodosCrud.delete(room);
            return true;
        }).orElse(false);
        return delect;
    }

}
