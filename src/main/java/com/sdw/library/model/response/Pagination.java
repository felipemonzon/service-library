package com.sdw.library.model.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Objeto de paginación.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 17/03/21
 */
@Getter
@SuperBuilder(toBuilder = true)
public class Pagination {
	/**
	 * Página actual.
	 */
	private int currentPage;
	/**
	 * Páginas totales.
	 */
	private int totalPages;
	/**
	 * Página final.
	 */
	private boolean lastPage;
	/**
	 * Página inicial.
	 */
	private boolean firstPage;
}
