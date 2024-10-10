package com.example.livro.service;

import com.example.livro.model.Livro;
import com.example.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {


    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro update(Livro livro) {
        Livro salvo = livroRepository.findById(livro.getId())
                .orElseThrow(() -> new RuntimeException("Livro nao encontrado")
                );
        salvo.setTitulo(livro.getTitulo());
        salvo.setAutor(livro.getAutor());
        salvo.setAnoPublicacao(livro.getAnoPublicacao());
        salvo.setPreco(livro.getPreco());
        return livroRepository.save(salvo);
    }

    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }
}



