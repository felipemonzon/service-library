package com.sdw.library.service;

import com.sdw.library.model.Author;
import com.sdw.library.model.response.AuthorsResponse;
import org.springframework.data.domain.Pageable;

/**
 * Servicio de autores.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 16/03/21
 */
public interface AuthorService {
	/**
	 * Consulta un listado de autores.
	 *
	 * @param pageable objeto de paginación {@code Pageable}
	 * @return una lista de autores.
	 */
	AuthorsResponse retrieve(Pageable pageable);

	/**
	 * Actualiza un autor.
	 *
	 * @param request DTO de editoriales {@code Author}
	 * @param id      identificador de un autor.
	 */
	void replaceAuthor(Author request, Long id);

	/**
	 * Guarda un autor.
	 *
	 * @param request DTO de editoriales {@code Author}
	 */
	void saveAuthor(Author request);
}
