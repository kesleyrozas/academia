package com.academia.controller;

import com.academia.entity.FichaTreino;
import com.academia.repository.FichaTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FichaTreinoController {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @RequestMapping(value = "/ficha", method = RequestMethod.GET)
    public List<FichaTreino> findAll(){
        return fichaTreinoRepository.findAll();
    }

    @RequestMapping(value = "/ficha/{id}", method = RequestMethod.GET)
    public ResponseEntity<FichaTreino> getById(@PathVariable(value = "id") long id){

        Optional<FichaTreino> fichaTreino = fichaTreinoRepository.findById(id);

        if(fichaTreino.isPresent()){
            return new ResponseEntity<FichaTreino>(fichaTreino.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/ficha", method = RequestMethod.POST)
    public FichaTreino salvar(@RequestBody FichaTreino fichaTreino){
        return fichaTreinoRepository.save(fichaTreino);
    }

    @RequestMapping(value = "/ficha/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id){

        Optional<FichaTreino> fichaTreino = fichaTreinoRepository.findById(id);

        if(fichaTreino.isPresent()){
            fichaTreinoRepository.delete(fichaTreino.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/ficha/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FichaTreino> atualizar(@PathVariable(value = "id") long id,
                                                 @RequestBody FichaTreino fichaTreino){
        Optional<FichaTreino> oldFichaTreino = fichaTreinoRepository.findById(id);
        if (oldFichaTreino.isPresent()){
            FichaTreino newFicha = oldFichaTreino.get();
            newFicha.setNumero(oldFichaTreino.get().getNumero());
            newFicha.setQuantidade(oldFichaTreino.get().getQuantidade());
            fichaTreinoRepository.save(newFicha);
            return new ResponseEntity<FichaTreino>(newFicha, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
