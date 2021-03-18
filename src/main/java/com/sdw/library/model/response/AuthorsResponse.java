package com.sdw.library.model.response;

import com.sdw.library.model.Author;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Respuesta de la API AUTHORS-RETRIEVE.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 17/03/21
 */
@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AuthorsResponse extends Pagination {
	/**
	 * Lista de autores.
	 */
	List<Author> authors;
}
