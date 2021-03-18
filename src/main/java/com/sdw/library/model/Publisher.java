package com.sdw.library.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @description: DTO para la api de editoriales.
 * @author: Felipe Monzón
 * @date: 8 mar. 2021
 * @version: 1.0.0
 */
@Data
public class Publisher {
	/**
	 * Identificador de editoriales.
	 */
	@NotNull
	private int id;
	/**
	 * Nombre de la editorial.
	 */
	@NotEmpty
	private String name;
}
