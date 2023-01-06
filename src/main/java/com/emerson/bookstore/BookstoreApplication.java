package com.emerson.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emerson.bookstore.domain.Categoria;
import com.emerson.bookstore.domain.Livro;
import com.emerson.bookstore.repositories.CategoriaRepository;
import com.emerson.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements  CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository ; 
	@Autowired
	private LivroRepository livroRepository ; 
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
  Categoria cat1 = new Categoria(null, "Informática ", "Livros de TI ") ; 
  Livro l1 = new Livro(null, "Código Fonte ", "João Barbosa Lima ", "Código limpo clean code", cat1 );
    cat1.getLivros().addAll(Arrays.asList(l1)) ; 
    
    this.categoriaRepository.saveAll(Arrays.asList(cat1)) ; 
    this.livroRepository.saveAll(Arrays.asList(l1)) ; 
    
		
	}

}
