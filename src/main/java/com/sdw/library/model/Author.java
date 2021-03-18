package com.sdw.library.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Petición para las APIs de autores.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 16/03/21
 */
@Data
public class Author {
	/**
	 * Identificador de la tabla.
	 */
	private Long id;
	/**
	 * Propiedad para el primer nombre del autor.
	 */
	@NotEmpty
	private String firstName;
	/**
	 * Segundo nombre.
	 */
	@NotEmpty
	private String lastName;
	/**
	 * Status del autor.
	 */
	@NotEmpty
	private String status;
}
