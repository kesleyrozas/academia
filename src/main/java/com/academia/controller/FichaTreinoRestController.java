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
@RequestMapping("/fichaTreino")
public class FichaTreinoRestController {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<FichaTreino> findAll() {
        return fichaTreinoRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<FichaTreino> getById(@PathVariable(value = "id") long id) {
        Optional<FichaTreino> fichaTreino = fichaTreinoRepository.findById(id);
        return fichaTreino.map(treino -> new ResponseEntity<>(treino, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public FichaTreino salvar(@RequestBody FichaTreino fichaTreino) {
        return fichaTreinoRepository.save(fichaTreino);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {

        Optional<FichaTreino> fichaTreino = fichaTreinoRepository.findById(id);

        if (fichaTreino.isPresent()) {
            fichaTreinoRepository.delete(fichaTreino.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
