package br.com.ad.sc.api.seguranca;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ad.sc.api.model.Usuario;
import br.com.ad.sc.api.repository.inter.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nmUsuario) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = usuarioRepository.buscarPorUsuario(nmUsuario);
		//Optional<Usuario> usuarioOptional = usuarioRepository.findById(new Long(nmUsuario));
		
		Usuario usuarioEncontrado = 
				usuarioOptional.orElseThrow(() -> 
				new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		
		return  new User(nmUsuario,usuarioEncontrado.getSenha(),getPermissoes(usuarioEncontrado));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuarioEncontrado) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		usuarioEncontrado.getPermissoes().forEach( p -> {
			authorities.add(new SimpleGrantedAuthority(p.getPermissao()));
			});
		return authorities;
	}
	
}
