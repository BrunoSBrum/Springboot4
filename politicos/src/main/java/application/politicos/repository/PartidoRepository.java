package application.politicos.repository;

import org.springframework.stereotype.Repository;

import application.politicos.model.Partidos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PartidoRepository extends JpaRepository<Partidos, Long> {

	Partidos findById(String partidoAssociado);

	Partidos findByNome(String nome);

	List<Partidos> findByIdeologia(String ideologia);

	






	

}
