package com.ad.sc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ad.sc.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	
	public  List<Livro> findByNmLivro( String  nmLivro );
	
	List<Livro> findByNmLivroIgnoreCaseContaining( String  nmLivro );
	

}
