package com.sdw.library.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Propiedades para la configuracion de swagger.
 * @author: Felipe Monzón
 * @date: Aug 4, 2020
 * @version: 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = ApiConstant.SWAGGER_PROPERTIES)
public class SwaggerProperties {
	/**
	 * Configuración de paquetes base de Swagger.
	 */
	private String basePackage;
	/**
	 * Titulo del Swagger.
	 */
	private String title;
	/**
	 * Descripción de la aplicación.
	 */
	private String descriptionApi;
	/**
	 * Versión del servicio.
	 */
	private String version;
	/**
	 * Nombre del desarrollador.
	 */
	private String developerName;
	/**
	 * URL de Contacto.
	 */
	private String contactUrl;
	/**
	 * Email del desarrollador.
	 */
	private String developerEmail;
}
