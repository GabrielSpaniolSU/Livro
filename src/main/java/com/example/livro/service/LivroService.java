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

    public Livro update(Livro produto) {
        Livro salvo = livroRepository.findById(produto.getId())
                .orElseThrow(() -> new RuntimeException("Livro nao encontrado")
                );
        salvo.setTitulo(Livro.getTitulo());
        salvo.setAutor(Livro.getAutor());
        salvo.setAno_publicacao(Livro.getAno_publicacao());
        salvo.setPreco(Livro.getPreco());
        return livroRepository.save(salvo);
    }

    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }
}



