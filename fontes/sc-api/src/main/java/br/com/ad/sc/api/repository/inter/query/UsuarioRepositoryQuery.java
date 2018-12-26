package br.com.ad.sc.api.repository.inter.query;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.ad.sc.api.model.Usuario;
@Repository
public interface UsuarioRepositoryQuery {
	public Optional<Usuario> buscarPorUsuario(String nmUsuario);  
}
