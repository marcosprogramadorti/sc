package br.com.ad.sc.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="BD_SC_CORP", name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PESSOA")
	private Long idPessoa;
	
	@Column(name="TP_PESSOA")
	private String tpPessoa;
	
	@Column(name="ST_ATIVO")
	private String stAtivo;
	
	@OneToMany
	@JoinColumn(name="ID_PESSOA")
	private List<PessoaEmail> pessoaEmails;
	
	@OneToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaFisica pessoaFisica;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public List<PessoaEmail> getPessoaEmails() {
		return pessoaEmails;
	}

	public void setPessoaEmails(List<PessoaEmail> pessoaEmails) {
		this.pessoaEmails = pessoaEmails;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	
}
