package com.sdw.library.exception.custom;

import java.util.Collections;
import java.util.List;

/**
 * @description: Excepción para badRequest.
 * @author: Felipe Monzón
 * @date: 12/03/21
 * @version: 1.0.0
 */
public class BadRequestException extends RuntimeException {
	/**
	 * UID auto generado para el versionado de la clase.
	 */
	private static final long serialVersionUID = 8925303792177335247L;

	/**
	 * Lista de campos incorrectos en la peticion.
	 */
	private final List<String> badFields;

	/**
	 * Constructor de la clase.
	 *
	 * @param message   mensaje de excepción arrojada por bad request.
	 * @param badFields lista de campos que originaron la excepción.
	 */
	public BadRequestException(String message, List<String> badFields) {
		super(message);
		this.badFields = Collections.unmodifiableList(badFields);
	}

	/**
	 * Obtiene la lista de campos incorrectos.
	 *
	 * @return Lista de los campos incorrectos.
	 */
	public List<String> getBadFields() {
		return badFields;
	}

}
