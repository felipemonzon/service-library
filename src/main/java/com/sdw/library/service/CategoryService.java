package com.sdw.library.service;

import com.sdw.library.model.Category;
import com.sdw.library.model.response.CategoriesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Servicio para las APIS de categorías
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 16/03/21
 */
public interface CategoryService {
	/**
	 * Guarda una categoría.
	 *
	 * @param request objeto {@code Category} de la API de categorías
	 */
	void save(Category request);

	/**
	 * Actualiza una categoría.
	 *
	 * @param request objeto {@code Category} de la API de categorías
	 * @param id      identificador de la categoría
	 */
	void replaceCategory(Category request, int id);

	/**
	 * Consulta las categorías.
	 *
	 * @param pageable objeto de paginación {@code Pageable}
	 * @return {@code Page} paginación de las categorías
	 */
	CategoriesResponse retrieve(Pageable pageable);
}
