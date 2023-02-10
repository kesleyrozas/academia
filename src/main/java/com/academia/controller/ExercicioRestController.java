package com.academia.controller;

import com.academia.entity.Exercicio;
import com.academia.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercicio")
public class ExercicioRestController {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Exercicio> findAll() {
        return exercicioRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Exercicio> getById(@PathVariable(value = "id") long id) {

        Optional<Exercicio> exercicio = exercicioRepository.findById(id);

        return exercicio.map(exercicio1 -> new ResponseEntity<>(exercicio1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public Exercicio salvar(@RequestBody Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {

        Optional<Exercicio> exercicio = exercicioRepository.findById(id);

        if (exercicio.isPresent()) {
            exercicioRepository.delete(exercicio.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
