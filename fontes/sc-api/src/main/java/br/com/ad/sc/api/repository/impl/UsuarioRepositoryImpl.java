package br.com.ad.sc.api.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.ad.sc.api.model.Usuario;
import br.com.ad.sc.api.repository.inter.query.UsuarioRepositoryQuery;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery {

	@PersistenceContext
	private EntityManager maneger;



	@Override
	public Optional<Usuario> buscarPorUsuario(String nmUsuario){

		CriteriaBuilder builder = maneger.getCriteriaBuilder();

		CriteriaQuery<Usuario> cr = builder.createQuery(Usuario.class);

		Root<Usuario> usuario = cr.from(Usuario.class);
		Predicate[] predicates = criarRestricoes(nmUsuario, builder, usuario);
		cr.where(predicates);
		
		try {
			TypedQuery<Usuario> query = maneger.createQuery(cr);
			Usuario u = query.getSingleResult();
			Optional<Usuario> uOptional = Optional.of(u); 
			return uOptional;
		} catch (Exception e) {
			return null;
		}
		

		
	}

	
	

	

	private Predicate[] criarRestricoes(String nmUsuario, CriteriaBuilder builder, Root<Usuario> usuario) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(nmUsuario)) {
			predicates.add(builder.equal(usuario.get("nmUsuario"), nmUsuario));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
