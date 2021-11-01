/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_Ciclo3.sevicio;

import Reto3_Ciclo3.modelo.Message;
import Reto3_Ciclo3.repositorio.MessageRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solecito
 */
@Service
public class serviciosMessage {
    @Autowired
    private MessageRepositorio metodosCrud;
    
    public List<Message> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage){
        return metodosCrud.getMessage(idMessage);
    }
    
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Message> evt=metodosCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
            return metodosCrud.save(message);
            }else{
                return message;
            }
        
        
        }
    
    }
     public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> evento=metodosCrud.getMessage(message.getIdMessage());
            if(evento.isEmpty()){
            if(message.getMessageText()!=null){
                    evento.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(evento.get());
                return evento.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int idMessage) {
        Boolean delect = getMessage(idMessage).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return delect;
    }
}