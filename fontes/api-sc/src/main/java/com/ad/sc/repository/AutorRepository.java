package com.ad.sc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ad.sc.entities.Autor;


@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>, AutorRepositoryQuery{
	
public  List<Autor> findByNmAutor( String  nmAutor );
	 
//	List<Autor> findBynmAutor( String  nmAutor );

}
