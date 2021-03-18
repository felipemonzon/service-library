package com.sdw.library.model;

import com.sdw.library.entity.AuthorEntity;
import com.sdw.library.entity.CategoryEntity;
import com.sdw.library.entity.PublisherEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * @description: Solicitud para el api de libros.
 * @author: Felipe Monzón
 * @date: 11/03/21
 * @version: 1.0.0
 */
@Data
public class Book {
	/**
	 * Identificador del libro.
	 */
	private long id;
	/**
	 * Nombre del libro.
	 */
	@NotEmpty
	private String title;
	/**
	 * ISBN.
	 */
	@NotEmpty
	private String isbn;
	/**
	 * Estatus del libro.
	 */
	private String status;
	/**
	 * Autores del libro.
	 */
	private Set<AuthorEntity> authors;
	/**
	 * Categorías del libro.
	 */
	private Set<CategoryEntity> categories;
	/**
	 * Editorial del libro.
	 */
	private PublisherEntity publisher;
}
