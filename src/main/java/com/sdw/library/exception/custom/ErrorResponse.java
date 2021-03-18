package com.sdw.library.exception.custom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sdw.library.utilities.Utilities;
import lombok.*;
import org.apache.commons.lang.StringUtils;

import java.time.ZonedDateTime;

/**
 * @description: Respuesta de error.
 * @author: Felipe Monzón
 * @date: 12/03/21
 * @version: 1.0.0
 */
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	/**
	 * Tipo de error.
	 */
	private String type;
	/**
	 * Código del error.
	 */
	@Builder.Default
	private String code = StringUtils.EMPTY;
	/**
	 * Detalles del error.
	 */
	@Builder.Default
	private String details = StringUtils.EMPTY;
	/**
	 * Ubicación del error.
	 */
	@Builder.Default
	private String location = StringUtils.EMPTY;
	/**
	 * Información adicional del error.
	 */
	@Builder.Default
	private String moreInfo = StringUtils.EMPTY;
	/**
	 * UUID header de la petición.
	 */
	@Builder.Default
	private String uuid = StringUtils.EMPTY;
	/**
	 * Fecha y hora cuando ocurre el error.
	 */
	@Builder.Default
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Utilities.ERROR_DATE_PATTER)
	private ZonedDateTime timestamp = ZonedDateTime.now();
}
