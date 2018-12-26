package br.com.ad.sc.api.repository.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ad.sc.api.model.PessoaFisica;
@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
	public Page<PessoaFisica> filtrar(PessoaFisica filtro, Pageable pageable); 
	public PessoaFisica bucarPorCpf(String cpf); 
}
