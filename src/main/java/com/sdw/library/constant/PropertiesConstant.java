package com.sdw.library.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Propiedades de la aplicación.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 17/03/21
 */
@Data
@Configuration
@ConfigurationProperties(prefix = ApiConstant.PROPERTY_PREFIX)
public class PropertiesConstant {
	/**
	 * Ruta para la intercepción de la petición.
	 */
	private String interceptorPath;
}
