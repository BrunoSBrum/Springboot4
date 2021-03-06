package application.politicos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.politicos.model.Associados;

public interface AssociadoRepository extends JpaRepository<Associados, Long> {

	List<Associados> findByCargo(String cargo);

	List<Associados> findByNome(Long idAssociado);

	List<Associados> findByNome(String name);

	Object listAll(Object any);
	
}

	
 