package br.com.ad.sc.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="BD_SC_CORP", name="pessoa_fisica")
public class PessoaFisica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PESSOA_FISICA")
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="DT_NASCIMENTO")
	private String dtNascimento;
	
	@Column(name="ST_ATIVO")
	private String stAtivo;
	
	@OneToMany(mappedBy="idPessoaFisica", fetch=FetchType.LAZY, cascade= {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
	private Set<PessoaEmail> listaEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public Set<PessoaEmail> getListaEmail() {
		return listaEmail;
	}

	public void setListaEmail(Set<PessoaEmail> listaEmail) {
		this.listaEmail = listaEmail;
	}
	

	

	
	

		
	

}
