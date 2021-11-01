package Reto3_Ciclo3.modelo;

import Reto3_Ciclo3.modelo.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author solecito
 */
@Entity
/**
 *
 * @tabla a apuntar
 */
@Table(name = "room")
/**
 *
 * Creamos la clase Room
 */
public class Room implements Serializable {

    /**
     *
     * @Creando atributos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * @Creando atributo
     */
    private Integer id;
    /**
     * @Creando atributo
     */
    private String name;
    /**
     * @Creando atributo
     */
    private String hotel;
    /**
     * @Creando atributo
     */
    private Integer stars;
    /**
     * @Creando atributo
     */
    private String description;

    /**
     * @Relacion muchos a uno categoria y room
     */
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    @JsonIgnoreProperties("rooms")
    private Categoria category;

    /**
     * @Relacion uno a muchos cliente y mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Message> messages;

    /**
     * @Relacion uno a muchos cliente y reservaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Reservation> reservations;

    /**
     * @getters y setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
