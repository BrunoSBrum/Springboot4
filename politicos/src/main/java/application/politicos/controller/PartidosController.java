package application.politicos.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import application.politicos.DTO.PartidoDto;
import application.politicos.controller.form.AtualizacaoPartidosForm;
import application.politicos.model.Partidos;
import application.politicos.repository.PartidoRepository;


@RestController @RequestMapping("/partidos")
public class PartidosController {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	//Listar partidos por ideologia ou listar todos
	
	@GetMapping
	public List<PartidoDto> listar(String ideologia){
		
		if(ideologia == null) {
			
			List<Partidos> partidos = partidoRepository.findAll();
			return PartidoDto.converter(partidos);
		}
		
		List<Partidos> partidos = partidoRepository.findByIdeologia(ideologia);
		return PartidoDto.converter(partidos);
	}
	
	//Listar portido especifico
	 
	@GetMapping("/{id}")
	public PartidoDto partidoEspecifico(@PathVariable Long id) {
		Partidos partidos = partidoRepository.getOne(id);
		return new PartidoDto(partidos);
	}
	
	@GetMapping("/associados")
	public List<Partidos> listarAssociados() {
		return partidoRepository.findAll();
		
		
	}
	
	//Cadastrar partido
	
	@PostMapping
	@Transactional
	public ResponseEntity<Partidos> cadastrarPartido(@RequestBody @Valid Partidos partidos
			, UriComponentsBuilder uriBuilder){
		
		partidoRepository.save(partidos);
		
		URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(partidos.getId()).toUri();
		return ResponseEntity.created(uri).body(partidos);
	}
	
	//Atualizar partido
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoPartidosForm form){
		
	Partidos partidos = form.atualizar(id, partidoRepository);
	return ResponseEntity.ok(new PartidoDto(partidos));
		
	}
	
	//Apagar partido
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		partidoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	


}
