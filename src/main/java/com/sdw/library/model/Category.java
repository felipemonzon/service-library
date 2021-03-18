package com.sdw.library.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Petición de la API categorías.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 16/03/21
 */
@Data
public class Category {
	/**
	 * Identificador de la categorías.
	 */
	private Integer id;
	/**
	 * Nombre de la categorías.
	 */
	@NotEmpty
	private String name;
	/**
	 * Estatus de la categorías.
	 */
	@NotEmpty
	private String status;
}
