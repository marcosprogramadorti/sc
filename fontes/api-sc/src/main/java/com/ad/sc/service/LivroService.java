package com.ad.sc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.exception.CampoObrigatorioException;
import com.ad.sc.entities.Livro;
import com.ad.sc.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> todos(){
		List<Livro> resultado = null;
		resultado = livroRepository.findAll();
		return resultado;
	}
	
	public Livro save(Livro livro) throws CampoObrigatorioException {
		if(livro.getNmLivro() == null || livro.getNmLivro().length() == 0 || livro.getNmLivro().equals("")) {
			  throw new CampoObrigatorioException("Nome  do Livro é Obrigatório");
			 
		} else {
			return livroRepository.save(livro);
		}
		
		
	}
	
	public Livro getById(Long idLivro) {
		return livroRepository.findById(idLivro).get();
	}
	
	public void delete(Long idLivro) {
		livroRepository.deleteById(idLivro);

	}
	public Livro atualiza(Livro l)  {
		return livroRepository.save(l);
	}
	
	public List<Livro> buscaPorNome (String nmLivro){
		return livroRepository.findByNmLivro(nmLivro);
	}
	
	public List<Livro> buscaPorQualquerParteNome (String nmLivro){
		return livroRepository.findByNmLivroIgnoreCaseContaining(nmLivro);
	}


}
