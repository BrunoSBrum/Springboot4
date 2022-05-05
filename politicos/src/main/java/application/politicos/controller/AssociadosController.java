package application.politicos.controller;


import java.net.URI;


import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import application.politicos.DTO.AssociadosDto;
import application.politicos.DTO.AssociadosEPartidoDto;
import application.politicos.controller.form.AssociadoNoPartido;
import application.politicos.controller.form.AssociadosForm;
import application.politicos.controller.form.AtualizacaoAssociadosForm;
import application.politicos.model.Associados;
import application.politicos.model.Partidos;
import application.politicos.repository.AssociadoRepository;
import application.politicos.repository.PartidoRepository;



@RestController @RequestMapping("/associados")
public class AssociadosController {
			
		
		@Autowired
		private AssociadoRepository associadoRepository;
		
		@Autowired
		private PartidoRepository partidoRepository;
		
		
		//Listar tudo ou filtrar por cargo e/ou ordenar por nome
		@GetMapping
		public List<AssociadosDto> listar(String cargo, String nome){
			
			if(cargo != null) {
				List<Associados> associados = associadoRepository.findByCargo(cargo);
				return AssociadosDto.converter(associados);
			}
			if(nome != null) {
				List<Associados> associados = associadoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
				return AssociadosDto.converter(associados);
				
			}
				List<Associados> associados = associadoRepository.findAll();
				return AssociadosDto.converter(associados);
		}
	
		//Listar por ID especifico
		@GetMapping("/{id}")
		public AssociadosDto itemEspecifico(@PathVariable Long id) {
			
			@SuppressWarnings("deprecation")
			Associados associados = associadoRepository.getOne(id);
			return new AssociadosDto(associados);
		}
		
		
		//Registrar novo associado
		@PostMapping
		@Transactional
		public ResponseEntity<AssociadosDto> cadastrar(@RequestBody @Valid AssociadosForm form
				, UriComponentsBuilder uriBuilder){
			
			Associados associados = form.converter();
			associadoRepository.save(associados);
			
			URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associados.getIdAssociado()).toUri();
			return ResponseEntity.created(uri).body(new AssociadosDto(associados));
		
		}
		
		//Registrar um partido no associado
		@PostMapping("/partidos")
		@Transactional
		public ResponseEntity<AssociadosEPartidoDto> cadastrarPartidoNoAssociado(@RequestBody AssociadoNoPartido form){
			
			Associados associados = form.vincularPartido(partidoRepository, associadoRepository);
			associadoRepository.save(associados);
			return ResponseEntity.ok(new AssociadosEPartidoDto(associados));
			
		
		}
		
		//Atualizar associado
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<AssociadosDto> atualizar(@PathVariable Long id,
				@RequestBody @Valid AtualizacaoAssociadosForm form){
			
			Associados associados = form.atualizar(id, associadoRepository);
			
			return ResponseEntity.ok(new AssociadosDto(associados));
			
		}
		
		//Apagar associado
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id){
			associadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		//Desvincular um partido de um associado
		
		@DeleteMapping("/{idAssociado}/partidos/{idPartido}")
		@Transactional
		public ResponseEntity<?> removerPartido(@PathVariable Long idAssociado, @PathVariable Long idPartido){
			System.out.println(idAssociado);
			System.out.println(idPartido);
			
			Associados associados = associadoRepository.findById(idAssociado).get();
			Partidos partidos = partidoRepository.findById(idPartido).get();
			System.out.println("------");
			System.out.println(partidos);
			partidos.getAssociados().remove(associados);
			return ResponseEntity.noContent().build();
		
		
		}
		
}
