package br.com.ad.sc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ad.sc.api.model.Pessoa;

public interface Pessoas extends JpaRepository<Pessoa, Long> {

}
