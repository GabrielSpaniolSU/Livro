package com.example.livro.controller;

import com.example.livro.model.Livro;
import com.example.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/produtos")
public class    LivroController {
    @Autowired
    private LivroService produtoService;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(livro));
    }

    @PutMapping
    public ResponseEntity<Livro> update(@RequestBody Livro livro) {
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoService.update(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}




