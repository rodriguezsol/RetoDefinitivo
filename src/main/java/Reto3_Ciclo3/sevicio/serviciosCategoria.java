/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Ciclo3.sevicio;

import Reto3_Ciclo3.repositorio.CategoriaRepositorio;
import Reto3_Ciclo3.modelo.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solecito
 */
@Service
public class serviciosCategoria {

    @Autowired
    private CategoriaRepositorio metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategory(int id) {
        return metodosCrud.getCategoria(id);
    }

    public Categoria save(Categoria category) {
        if (category.getId() == null) {
            return metodosCrud.save(category);
        } else {
            Optional<Categoria> evt = metodosCrud.getCategoria(category.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(category);
            } else {
                return category;
            }

        }

    }

    public Categoria update(Categoria category) {
        if (category.getId() != null) {
            Optional<Categoria> evento = metodosCrud.getCategoria(category.getId());
            if (!evento.isEmpty()) {
                if (category.getDescription()!= null) {
                    evento.get().setDescription(category.getDescription());
                }
                if (category.getName()!= null) {
                    evento.get().setName(category.getName());
                }
                return metodosCrud.save(evento.get());
            }

        }
        return category;
    }

    public boolean deletecategoria(int id) {
        Boolean delec = getCategory(id).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return delec;
    }

}
