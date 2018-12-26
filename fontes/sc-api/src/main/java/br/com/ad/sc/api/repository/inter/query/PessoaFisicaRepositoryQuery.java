package br.com.ad.sc.api.repository.inter.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.ad.sc.api.model.PessoaFisica;
@Repository
public interface PessoaFisicaRepositoryQuery		 {
	public Page<PessoaFisica> filtrar (PessoaFisica filtro, Pageable pageable);
	public PessoaFisica bucarPorCpf(String cpf); 
}
