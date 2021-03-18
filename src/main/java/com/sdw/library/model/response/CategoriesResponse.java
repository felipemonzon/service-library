package com.sdw.library.model.response;

import com.sdw.library.model.Category;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Respuesta de la API de CATEGORY-RETRIEVE
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 17/03/21
 */
@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class CategoriesResponse extends Pagination {
	/**
	 * Lista de categorías.
	 */
	private List<Category> categories;
}
