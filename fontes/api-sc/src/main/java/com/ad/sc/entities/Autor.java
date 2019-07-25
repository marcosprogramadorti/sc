package com.ad.sc.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class Autor {
	
	@Id
	@Column(name = "ID_AUTOR")
	private long idAutor;
	
	@Column(name = "NM_AUTOR")
	private String nmAutor;
	
	@Column(name = "CPF_AUTOR")
	private String cpfAutor;
	
	@OneToMany
	@JoinColumn(name = "ID_AUTOR")
	private List< Livro> livros;

	

	public String getCpfAutor() {
		return cpfAutor;
	}

	public void setCpfAutor(String cpfAutor) {
		this.cpfAutor = cpfAutor;
	}

	public long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNmAutor() {
		return nmAutor;
	}

	public void setNmAutor(String nmAutor) {
		this.nmAutor = nmAutor;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	

}
