package br.com.ad.sc.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ad.sc.api.model.PessoaFisica;
import br.com.ad.sc.api.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoaFisica")
public class PessoaResource {
	
	@Autowired
	PessoaFisicaService pessoaFisicaService;	
	
	@GetMapping
	public List<PessoaFisica> listar() {
		return pessoaFisicaService.listar();
	}
	
	@PostMapping
	public ResponseEntity<PessoaFisica> salvar( @RequestBody PessoaFisica pessoaFisica, HttpServletResponse response ) {
		PessoaFisica pessoaFisicaSalva  = pessoaFisicaService.salvar(pessoaFisica);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaFisicaSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(pessoaFisicaSalva);
	}
	
	@GetMapping("/teste")
	public String teste(){
		return "OK";
	}

}
