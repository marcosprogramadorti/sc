package br.com.ad.sc.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.ad.sc.api.model.PessoaFisica;
import br.com.ad.sc.api.repository.inter.query.PessoaFisicaRepositoryQuery;

@Repository
public class PessoaFisicaRepositoryImpl implements PessoaFisicaRepositoryQuery {

	@PersistenceContext
	private EntityManager maneger;

	@Override
	public Page<PessoaFisica> filtrar(PessoaFisica filtro, Pageable pageable) {

		CriteriaBuilder builder = maneger.getCriteriaBuilder();

		CriteriaQuery<PessoaFisica> cr = builder.createQuery(PessoaFisica.class);

		Root<PessoaFisica> pessoaFisica = cr.from(PessoaFisica.class);
		Predicate[] predicates = criarRestricoes(filtro, builder, pessoaFisica);
		cr.where(predicates);

		TypedQuery<PessoaFisica> query = maneger.createQuery(cr);

		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(filtro));

	}

	@Override
	public PessoaFisica bucarPorCpf(String cpf) {

		CriteriaBuilder builder = maneger.getCriteriaBuilder();

		CriteriaQuery<PessoaFisica> cr = builder.createQuery(PessoaFisica.class);

		Root<PessoaFisica> pessoaFisica = cr.from(PessoaFisica.class);
		Predicate[] predicates = criarRestricoes(cpf, builder, pessoaFisica);
		cr.where(predicates);

		try {
			TypedQuery<PessoaFisica> query = maneger.createQuery(cr);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		

		
	}

	private Predicate[] criarRestricoes(PessoaFisica filtro, CriteriaBuilder builder, Root<PessoaFisica> pessoaFisica) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(filtro.getIdPessoaFisica())) {
			predicates.add(builder.equal(pessoaFisica.get("idPessoaFisica"), filtro.getIdPessoaFisica()));
		}
		if (!StringUtils.isEmpty(filtro.getCpf())) {
			predicates.add(builder.equal(pessoaFisica.get("cpf"), filtro.getCpf()));
		}
		if (!StringUtils.isEmpty(filtro.getNome())) {
			predicates.add(
					builder.like(builder.lower(pessoaFisica.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<PessoaFisica> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistroPorPagina);

	}

	private Long total(PessoaFisica filtro) {

		CriteriaBuilder builder = maneger.getCriteriaBuilder();

		CriteriaQuery<Long> cr = builder.createQuery(Long.class);

		Root<PessoaFisica> pessoaFisica = cr.from(PessoaFisica.class);
		Predicate[] predicates = criarRestricoes(filtro, builder, pessoaFisica);
		cr.where(predicates);
		cr.select(builder.count(pessoaFisica));
		return maneger.createQuery(cr).getSingleResult();
	}

	private Predicate[] criarRestricoes(String cpf, CriteriaBuilder builder, Root<PessoaFisica> pessoaFisica) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(cpf)) {
			predicates.add(builder.equal(pessoaFisica.get("cpf"), cpf));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
