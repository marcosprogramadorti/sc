package br.com.ad.sc.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ad.sc.api.model.PessoaFisica;
import br.com.ad.sc.api.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	PessoaFisicaRepository pessoaFisicaRepository;

	public List<PessoaFisica> listar() {
		return pessoaFisicaRepository.findAll();
	}

	public PessoaFisica salvar(PessoaFisica pessoa) {

		PessoaFisica pessoaFisicaSalva = pessoaFisicaRepository.save(pessoa);
		atualizarIdPessoa(pessoa, pessoaFisicaSalva.getId());
		pessoaFisicaSalva = pessoaFisicaRepository.save(pessoa);
		

		return pessoaFisicaSalva;

	}

	private void atualizarIdPessoa(PessoaFisica pessoa, Long id) {
		pessoa.getListaEmail().forEach(item->{
			pessoa.setId(id);
		});
		
	}



}
