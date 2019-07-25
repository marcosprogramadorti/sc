package com.ad.sc.resource;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ad.exception.CampoObrigatorioException;
import com.ad.sc.entities.Livro;
import com.ad.sc.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping("/teste")
	public List<Livro> teste (){
		List<Livro> resultado = new ArrayList<Livro>();
		Livro l = new Livro();
		l.setIdAutor(1L);
		l.setIdLivro(1l);
		l.setNmLivro("Teste");
		l.setNmPagina(55);
		resultado.add(l);
		return resultado;
	}
	
	@GetMapping("/todos")
	public List<Livro> todos (){
		List<Livro> resultado = null;
		resultado = livroService.todos();
		return resultado;
	}
	
	@GetMapping("/buscaPorNome")
	public List<Livro> buscaPorNome (String nmLivro){
		List<Livro> resultado = null;
		resultado = livroService.buscaPorNome(nmLivro);
		return resultado;
	}
	
	@GetMapping("/buscaPorQualquerParteNome")
	public List<Livro> buscaPorQualquerParteNome (String nmLivro){
		List<Livro> resultado = null;
		resultado = livroService.buscaPorQualquerParteNome(nmLivro);
		return resultado;
	}
	
	
	@PostMapping("/novo")
	public Livro save(@RequestBody Livro livro) throws CampoObrigatorioException {
		Livro livroSalvo = null;
		livroSalvo = livroService.save(livro);
		return livroSalvo;
	}
	
	@PutMapping("/update")
	public Livro atualiza( Livro l	) {
		return livroService.atualiza(l);
	}
    
	
	@DeleteMapping("/deletar")
    public void delete(@PathVariable Long idLivro) {
		livroService.delete(idLivro);
	}
	
	
	
}

