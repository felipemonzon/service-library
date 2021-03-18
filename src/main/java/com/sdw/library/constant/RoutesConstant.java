package com.sdw.library.constant;

/**
 * @description: Constantes de rutas.Ø
 * @author: Felipe Monzón
 * @date: 11 Mar. 2021
 * @version: 1.0.0
 */
public abstract class RoutesConstant {
	/**
	 * Ruta base del proyecto.
	 */
	public static final String BASE_PATH = "${api.uri.basePath}";
	/**
	 * Ruta para la consulta de libros.
	 */
	public static final String BOOKS_RETRIEVE_PATH = "${api.uri.books.retrieve.mapping}";
	/**
	 * Ruta para el guardado de libros.
	 */
	public static final String BOOKS_SAVE_PATH = "${api.uri.books.save.mapping}";
	/**
	 * Ruta para la actualización de libros.
	 */
	public static final String BOOKS_UPDATE_PATH = "${api.uri.books.update.mapping}";
	/**
	 * Ruta para la consulta de editoriales.
	 */
	public static final String PUBLISHERS_RETRIEVE_PATH = "${api.uri.publisher.retrieve.mapping}";
	/**
	 * Ruta para el guardado de editoriales.
	 */
	public static final String PUBLISHERS_SAVE_PATH = "${api.uri.publisher.save.mapping}";
	/**
	 * Ruta para la actualización de editoriales.
	 */
	public static final String PUBLISHERS_UPDATE_PATH = "${api.uri.publisher.update.mapping}";
	/**
	 * Ruta para la consulta de categorías.
	 */
	public static final String CATEGORIES_RETRIEVE_PATH = "${api.uri.categories.retrieve.mapping}";
	/**
	 * Ruta para el guardado de categorías.
	 */
	public static final String CATEGORIES_SAVE_PATH = "${api.uri.categories.save.mapping}";
	/**
	 * Ruta para la actualización de categorías.
	 */
	public static final String CATEGORIES_UPDATE_PATH = "${api.uri.categories.update.mapping}";
	/**
	 * Ruta para la consulta de autores.
	 */
	public static final String AUTHORS_RETRIEVE_PATH = "${api.uri.authors.retrieve.mapping}";
	/**
	 * Ruta para el guardado de autores.
	 */
	public static final String AUTHORS_SAVE_PATH = "${api.uri.authors.save.mapping}";
	/**
	 * Ruta para la actualización de autores.
	 */
	public static final String AUTHORS_UPDATE_PATH = "${api.uri.authors.update.mapping}";

	/**
	 * Constructor de la class.
	 */
	private RoutesConstant() {
	}
}
