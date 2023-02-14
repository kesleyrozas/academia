package com.academia.controller;

import com.academia.entity.Pessoa;
import com.academia.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaRestController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> getById(@PathVariable(value = "id") long id) {
        Optional<Pessoa> exercicio = pessoaRepository.findById(id);
        return exercicio.map(exercicio1 -> new ResponseEntity<>(exercicio1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
