package com.sdw.library.api;

import com.sdw.library.constant.RoutesConstant;
import com.sdw.library.model.Category;
import com.sdw.library.model.response.CategoriesResponse;
import com.sdw.library.service.CategoryService;
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
 * Apis para el modulo de categorías.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 8 dic. 2020
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RoutesConstant.BASE_PATH)
public class CategoryController {
	/**
	 * Servicio de categorías.
	 */
	private final CategoryService categoryService;

	/**
	 * API para guardar una categoría.
	 *
	 * @param request objeto {@code Category} de la API de categorías
	 * @return HttpStatus CREATED cuando la categoría se guardo correctamente
	 */
	@PostMapping(path = RoutesConstant.CATEGORIES_SAVE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@RequestBody @Valid Category request) {
		this.categoryService.save(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * API para listar todas las categorías.
	 *
	 * @param pageable objeto de paginación {@code Pageable}
	 * @return {@code Page} paginación de las categorías
	 */
	@GetMapping(path = RoutesConstant.CATEGORIES_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriesResponse> retrieve(@PageableDefault() Pageable pageable) {
		return ResponseEntity.ok(this.categoryService.retrieve(pageable));
	}

	/**
	 * API para actualizar una categoría.
	 *
	 * @param request objeto {@code Category} de la API de categorías
	 * @param id      identificador de la categoría
	 */
	@PutMapping(path = RoutesConstant.CATEGORIES_UPDATE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> replaceCategory(@RequestBody @Valid Category request, @PathVariable int id) {
		this.categoryService.replaceCategory(request, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
