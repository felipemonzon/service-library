package com.sdw.library.api;

import com.sdw.library.constant.RoutesConstant;
import com.sdw.library.model.Publisher;
import com.sdw.library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: EndPoint para las apis de Editoriales.
 * @author: Felipe Monzón
 * @date: 17 feb. 2021
 * @version: 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RoutesConstant.BASE_PATH)
public class PublisherController {
	/**
	 * Servicio de editoriales.
	 */
	private final PublisherService publisherService;

	/**
	 * API que consulta todas las editoriales.
	 *
	 * @return lista de todas las editoriales
	 */
	@GetMapping(path = RoutesConstant.PUBLISHERS_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Publisher>> retrieve(@PageableDefault() Pageable pageable) {
		return ResponseEntity.ok(this.publisherService.retrieve(pageable));
	}

	/**
	 * API para guardar una editorial.
	 *
	 * @param request entrada de la API {@code Publisher}
	 * @return HttpStatus CREATED si se guardo con éxito
	 */
	@PostMapping(path = RoutesConstant.PUBLISHERS_SAVE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@RequestBody @Valid Publisher request) {
		this.publisherService.save(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * API para actualizar una editorial.
	 *
	 * @param request entrada de la API {@code Publisher}
	 * @param id      identificador de la editorial
	 * @return HttpStatus NO_CONTENT si se actualizo con éxito
	 */
	@PutMapping(path = RoutesConstant.PUBLISHERS_UPDATE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@RequestBody @Valid Publisher request,
	                                   @PathVariable int id) {
		this.publisherService.replacePublisher(request, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
