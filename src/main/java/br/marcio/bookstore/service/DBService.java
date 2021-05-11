package br.marcio.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.marcio.bookstore.domain.Categoria;
import br.marcio.bookstore.domain.Livro;
import br.marcio.bookstore.repositories.CategoriaRepository;
import br.marcio.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Autowired
	private LivroRepository livroRepository; 
	 
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Informática", "Livro Java");
		Categoria cat3 =  new Categoria(null, "informática", "Livro Angular");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Full stack", "Backend completo", "Frontend completo", cat2);
		Livro l3 = new Livro(null, "Frontend avançado", "Frontend básico", "Full stack completo", cat3);
		Livro l4 = new Livro(null, "Hacker ético", "Tudo sobre redes", "Usando cmd", cat1);
		Livro l5 = new Livro(null, "Java e mysql", "Spring e React", "Spring e Angular", cat2)
				;
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
