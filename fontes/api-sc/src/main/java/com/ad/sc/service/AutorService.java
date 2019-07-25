package com.ad.sc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ad.exception.CampoObrigatorioException;
import com.ad.sc.entities.Autor;
import com.ad.sc.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;
	
	
	public List<Autor> todosAutores(){
		List<Autor> resultado = null;
		resultado = autorRepository.findAll();
		return resultado;
	}

	public Autor save(Autor autor) throws CampoObrigatorioException {
		if(autor.getNmAutor() == null || autor.getNmAutor().length() == 0 || autor.getNmAutor().equals("")) {
			  throw new CampoObrigatorioException("Nome  do autor é Obrigatório");
			 
		} else {
			return autorRepository.save(autor);
		}
		
		
	}
	
	public Autor getById(Long idAutor) {
		return autorRepository.findById(idAutor).get();
	}
	
	public void delete(Long idAutor) {
		autorRepository.deleteById(idAutor);

	}
	public Autor atualiza(Autor a)  {
		return autorRepository.save(a);
	}
	
	public List<Autor> buscaNomeAutor (String nmAutor){
		return autorRepository.findByNmAutor(nmAutor);
	}
	
	public List<Autor> buscaPorQualquerParteNomeAutor (String nmAutor){
		return autorRepository.findByNmAutor(nmAutor);
	}
	
	public List<Autor> buscarPorNome(String nmAutor){
		return autorRepository.buscarPorNome(nmAutor);
	} 

	
	
	
	
}
