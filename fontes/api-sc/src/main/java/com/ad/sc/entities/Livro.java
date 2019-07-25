package com.ad.sc.entities;

import javax.persistence.*;

@Entity
@Table(name = "LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_LIVRO")
    private Long idLivro;
    
    @Column(name="ID_AUTOR")
    private Long idAutor;
    
    @Column(name="NM_LIVRO")
    private String nmLivro;
    
    @Column(name="NM_PAGINA")
    private int nmPagina;

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public String getNmLivro() {
		return nmLivro;
	}

	public void setNmLivro(String nmLivro) {
		this.nmLivro = nmLivro;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public int getNmPagina() {
		return nmPagina;
	}

	public void setNmPagina(int nmPagina) {
		this.nmPagina = nmPagina;
	}
    
    
}
