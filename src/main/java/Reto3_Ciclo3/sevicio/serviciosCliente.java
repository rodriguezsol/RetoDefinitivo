
package Reto3_Ciclo3.sevicio;

import Reto3_Ciclo3.modelo.Client;
import Reto3_Ciclo3.repositorio.ClienteRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solecito
 */
@Service
public class serviciosCliente {
   @Autowired
    private ClienteRepositorio metodosCrud;
    
    public List<Client> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return metodosCrud.getClient(idClient);
    }
    
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
            return metodosCrud.save(client);
            }else{
                return client;
            }
        
        
        }
    
    }
   public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> evento= metodosCrud.getClient(client.getIdClient());
            if(!evento.isEmpty()){
                if(client.getName()!=null){
                    evento.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    evento.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evento.get().setPassword(client.getPassword());
                }
                metodosCrud.save(evento.get());
                return evento.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int idClient) {
        Boolean delect = getClient(idClient).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return delect;
    }

}
