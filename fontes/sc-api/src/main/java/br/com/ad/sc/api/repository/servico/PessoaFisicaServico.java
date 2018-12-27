package br.com.ad.sc.api.repository.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ad.sc.api.model.PessoaFisica;
import br.com.ad.sc.api.exceptions.CpfDuplicadoException;
import br.com.ad.sc.api.exceptions.CpfInvalidoException;
import br.com.ad.sc.api.repository.inter.PessoaFisicaRepository;
import br.com.ad.sc.api.repository.util.ValidaCpf;

@Service
public class PessoaFisicaServico {
	
	@Autowired
	PessoaFisicaRepository pessoaFisicaRepository;
	
	public Page<PessoaFisica> pesquisar(PessoaFisica  filtro, Pageable pageable ){
		return pessoaFisicaRepository.filtrar(filtro, pageable);
	}
	
	public List<PessoaFisica> listar() {
		return pessoaFisicaRepository.findAll();
	}
	
	public PessoaFisica salvar(PessoaFisica pessoaFisica) throws CpfDuplicadoException, CpfInvalidoException {
		if (!ValidaCpf.isCPF(pessoaFisica.getCpf())) {
			throw new CpfInvalidoException("Cpf Inválido");
		}
		
		PessoaFisica pessoaDublicada = pessoaFisicaRepository.bucarPorCpf(pessoaFisica.getCpf());	
		
		if (pessoaFisica.getIdPessoaFisica() == null) {
			
			if (pessoaDublicada != null) {
					throw new CpfDuplicadoException("Cpf Dublicado ID: " 
							+ pessoaDublicada.getIdPessoaFisica() 
							+ ",  ID: " 
							+ pessoaFisica.getIdPessoaFisica()   );
			}
		}else if (pessoaDublicada != null && !pessoaDublicada.getIdPessoaFisica().equals(pessoaFisica.getIdPessoaFisica())){
			throw new CpfDuplicadoException("Cpf Dublicado ID: " 
					+ pessoaDublicada.getIdPessoaFisica() 
					+ ",  ID: " 
					+ pessoaFisica.getIdPessoaFisica()   );
		}
		
		
		PessoaFisica pessoaFisicaSalva = pessoaFisicaRepository.save(pessoaFisica);
		//atualizarIdPessoa(pessoaFisica, pessoaFisicaSalva.getIdPessoaFisica());
		pessoaFisicaSalva = pessoaFisicaRepository.save(pessoaFisica);
		return pessoaFisicaSalva;	
		
	}
	
//	private void atualizarIdPessoa(PessoaFisica pessoa, Long id) {
//		pessoa.getListaEmail().forEach(item->{
//			pessoa.setId(id);
//		});
//		
//	}
}
	