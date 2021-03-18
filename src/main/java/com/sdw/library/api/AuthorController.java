package com.sdw.library.api;

import com.sdw.library.constant.RoutesConstant;
import com.sdw.library.entity.AuthorEntity;
import com.sdw.library.model.Author;
import com.sdw.library.model.response.AuthorsResponse;
import com.sdw.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * APIS para el modulo de autores.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 17 feb. 2021
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RoutesConstant.BASE_PATH)
public class AuthorController {
	/**
	 * Servicio de autores.
	 */
	private final AuthorService authorService;

	/**
	 * API para consultar las categorías.
	 *
	 * @param pageable objeto de paginación {@code Pageable}
	 * @return lista de autores
	 */
	@GetMapping(path = RoutesConstant.AUTHORS_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorsResponse> retrieve(@PageableDefault() Pageable pageable) {
		return ResponseEntity.ok(this.authorService.retrieve(pageable));
	}

	/**
	 * API para guardar un autor.
	 *
	 * @param request objeto {@code Author} de la API de autores
	 * @return HttpStatus CREATED cuando el autor se guardó correctamente
	 */
	@PostMapping(path = RoutesConstant.AUTHORS_SAVE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorEntity> save(@RequestBody @Valid Author request) {
		this.authorService.saveAuthor(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * API para actualizar un autor.
	 *
	 * @param request entrada de la API {@code Author}
	 * @param id      identificador del autor
	 * @return HttpStatus NO_CONTENT si se actualizo con éxito
	 */
	@PutMapping(path = RoutesConstant.AUTHORS_UPDATE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@RequestBody @Valid Author request, @PathVariable Long id) {
		this.authorService.replaceAuthor(request, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
