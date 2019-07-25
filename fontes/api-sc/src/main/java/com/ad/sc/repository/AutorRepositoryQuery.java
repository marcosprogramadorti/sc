package com.ad.sc.repository;

import java.util.List;

import com.ad.sc.entities.Autor;

public interface AutorRepositoryQuery {
	public List<Autor> buscarPorNome(String nmAutor);
}
