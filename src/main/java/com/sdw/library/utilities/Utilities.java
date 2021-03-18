package com.sdw.library.utilities;

import com.sdw.library.constant.ApiConstant;
import org.springframework.data.domain.Pageable;

/**
 * @description:
 * @author: Felipe Monzón
 * @date: 12/03/21
 * @version: 1.0.0
 */
public abstract class Utilities {
	/**
	 * Formato de salida de la respuesta de error.
	 */
	public static final String ERROR_DATE_PATTER = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Obtiene la pagina actual.
	 *
	 * @param pageable datos de paginación
	 * @return pagina actual
	 */
	public static int getCurrentPage(Pageable pageable) {
		int page = pageable.getPageNumber();
		if (pageable.getPageNumber() != ApiConstant.INT_ZERO_VALUE) {
			page -= ApiConstant.INT_ONE_VALUE;
		}
		return page;
	}
}
