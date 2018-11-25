package br.com.ad.sc.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="BD_SC_CORP", name="pessoa_email")
public class PessoaEmail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PESSOA_EMAIL")
	private Long idPessoaEmail;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ST_PRINCIPAL")
	private String stPrincipal;

	public Long getIdPessoaEmail() {
		return idPessoaEmail;
	}

	public void setIdPessoaEmail(Long idPessoaEmail) {
		this.idPessoaEmail = idPessoaEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStPrincipal() {
		return stPrincipal;
	}

	public void setStPrincipal(String stPrincipal) {
		this.stPrincipal = stPrincipal;
	}

		
	
	
	
	

}
