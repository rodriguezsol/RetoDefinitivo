/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_Ciclo3.sevicio;

import Reto3_Ciclo3.modelo.Reservation;
import Reto3_Ciclo3.reportes.ContadorClientes;
import Reto3_Ciclo3.reportes.StatusReservas;
import Reto3_Ciclo3.repositorio.ReservationRepositorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solecito
 */
@Service
public class serviciosReservation {

    @Autowired
    private ReservationRepositorio metodosCrud;

    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation) {
        return metodosCrud.getReservation(idReservation);
    }

    public Reservation save(Reservation reservations) {
        if (reservations.getIdReservation() == null) {
            return metodosCrud.save(reservations);
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(reservations.getIdReservation());
            if (evt.isEmpty()) {
                return metodosCrud.save(reservations);
            } else {
                return reservations;
            }

        }

    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> evento = metodosCrud.getReservation(reservation.getIdReservation());
            if (!evento.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    evento.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    evento.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    evento.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evento.get());
                return evento.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int idReservation) {
        Boolean delect = getReservation(idReservation).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return delect;
    }
    public StatusReservas reporteStatusServicio (){
        List<Reservation>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     public List<ContadorClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        } 

}
