package br.com.ad.sc.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ad.sc.api.model.Pessoa;
import br.com.ad.sc.api.repository.Pessoas;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	Pessoas pessoas;
	
	@GetMapping
	public List<Pessoa> listar() {
		return pessoas.findAll();
	}
	
	@GetMapping("/teste")
	public String teste(){
		return "OK";
	}

}
