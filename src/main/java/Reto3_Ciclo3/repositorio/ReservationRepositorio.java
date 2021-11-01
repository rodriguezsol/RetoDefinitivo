/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_Ciclo3.repositorio;

import Reto3_Ciclo3.interfaces.interfaceReservation;
import Reto3_Ciclo3.modelo.Client;
import Reto3_Ciclo3.modelo.Reservation;
import Reto3_Ciclo3.reportes.ContadorClientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author solecito
 */
@Repository
public class ReservationRepositorio {
    @Autowired
    private interfaceReservation crud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    public Optional <Reservation> getReservation(int id){
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservations){
        return crud.save(reservations);
    }
    public void delete(Reservation reservations){
        crud.delete(reservations);
    }
    public List<Reservation> ReservacionStatusRepositorio (String status){
         return crud.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
}
