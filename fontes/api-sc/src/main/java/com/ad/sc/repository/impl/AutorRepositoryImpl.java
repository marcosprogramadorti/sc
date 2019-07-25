package com.ad.sc.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ad.sc.entities.Autor;
import com.ad.sc.repository.AutorRepositoryQuery;

public class AutorRepositoryImpl implements AutorRepositoryQuery {
	
	@PersistenceContext
	private EntityManager maneger;

	@Override
	public List<Autor> buscarPorNome(String nmAutor) {
		CriteriaBuilder builder = maneger.getCriteriaBuilder();
		CriteriaQuery<Autor> cr = builder.createQuery(Autor.class);
		Root<Autor> autor = cr.from(Autor.class);
//		cr.multiselect(autor.get("nmAutor"),autor.get("cpfAutor")  );
		
		
		cr.where(builder.equal (  builder.trim(autor.get("nmAutor"))              ,  nmAutor.trim() )    );
		
		TypedQuery<Autor> query = maneger.createQuery(cr);
		return query.getResultList();
	}
	
	
	private Predicate[] criarRestricoes(CriteriaBuilder builder ,String nmAutor, Root<Autor> autor   ) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (nmAutor != null ) {
			predicates.add(	builder.equal(autor.get("nmAutor"), nmAutor)); 		
		}
		
		return null;
		
	}

	

}
