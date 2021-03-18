package com.sdw.library.service;

import com.sdw.library.model.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @description: Servicio de editorial.
 * @author: Felipe Monzón
 * @date: 14/03/21
 * @version: 1.0.0
 */
public interface PublisherService {
	/**
	 * Guarda una editorial.
	 *
	 * @param request DTO de editoriales {@code Publisher}
	 */
	void save(Publisher request);

	/**
	 * Actualiza una editorial.
	 *
	 * @param request DTO de editoriales {@code Publisher}
	 * @param id      identificador de la editorial.
	 */
	void replacePublisher(Publisher request, int id);

	/**
	 * Consulta todas las editoriales.
	 *
	 * @param pageable objeto de paginación {@code Pageable}
	 * @return una lista de editoriales.
	 */
	Page<Publisher> retrieve(Pageable pageable);
}
