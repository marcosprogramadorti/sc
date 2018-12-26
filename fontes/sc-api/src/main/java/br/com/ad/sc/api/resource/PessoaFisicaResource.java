package br.com.ad.sc.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ad.sc.api.model.PessoaFisica;
import br.com.ad.sc.api.exceptions.CpfDuplicadoException;
import br.com.ad.sc.api.exceptions.CpfInvalidoException;
import br.com.ad.sc.api.repository.servico.PessoaFisicaServico;



@RestController
@RequestMapping("/pessoaFisica")
public class PessoaFisicaResource {
	
	@Autowired
	PessoaFisicaServico pessoaFisicaServico;
	
	@GetMapping
	public Page<PessoaFisica> pesquisar(PessoaFisica  filtro, Pageable pageable ){
		return pessoaFisicaServico.pesquisar(filtro, pageable);
	}
	
	
	@GetMapping("/listar")
	public List<PessoaFisica> listar() {
		return pessoaFisicaServico.listar();
	}
	
	
	@GetMapping("/teste")
	public String teste(){
		return "OK";
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody PessoaFisica pessoaFisica, HttpServletResponse response)  {
		PessoaFisica pessoaSalva = null;
		URI uri = null;
		try {
			pessoaSalva = pessoaFisicaServico.salvar(pessoaFisica);
		} catch (CpfDuplicadoException e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		} catch (CpfInvalidoException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getIdPessoaFisica()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(pessoaSalva);
			

	}

}
