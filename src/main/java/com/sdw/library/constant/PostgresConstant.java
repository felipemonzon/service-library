package com.sdw.library.constant;

/**
 * @description: Constantes para postgres.
 * @author: Felipe Monzón
 * @date: 2 mar. 2021
 * @version: 1.0.0
 */
public abstract class PostgresConstant {
	/**
	 * Propiedad para el nombre de la tabla "users".
	 */
	public static final String USERS_TABLE = "users";
	/**
	 * Propiedad para el campo "create_user".
	 */
	public static final String CREATE_USER = "create_user";
	/**
	 * Propiedad para el campo "create_date".
	 */
	public static final String CREATE_DATE = "create_date";
	/**
	 * Propiedad para el campo "lastmodified_user".
	 */
	public static final String LAST_MODIFIED_USER = "lastmodified_user";
	/**
	 * Propiedad para el campo "lastmodified_date".
	 */
	public static final String LAST_MODIFIED_DATE = "lastmodified_date";
	/**
	 * Propiedad para el nombre de la tabla "categorias".
	 */
	public static final String CATEGORIES_TABLE = "categories";
	/**
	 * Propiedad para el campo "description".
	 */
	public static final String DESCRIPTION_FIELD = "description";
	/**
	 * Propiedad para el nombre de la tabla "books".
	 */
	public static final String BOOKS_TABLE = "books";
	/**
	 * Propiedad para el nombre de la tabla "author_writter".
	 */
	public static final String AUTHOR_WRITTER_TABLE = "author_writter";
	/**
	 * Propiedad para el campo "book_id".
	 */
	public static final String BOOK_ID_FIELD = "book_id";
	/**
	 * Propiedad para el campo "title".
	 */
	public static final String BOOK_TITLE_FIELD = "title";
	/**
	 * Propiedad para el campo "author_id".
	 */
	public static final String AUTHOR_ID_FIELD = "author_id";
	/**
	 * Propiedad para el nombre de la tabla "authors".
	 */
	public static final String AUTHORS_TABLE = "authors";
	/**
	 * Propiedad para primer nombre.
	 */
	public static final String FIRST_NAME_PROPERTY = "firstName";
	/**
	 * Propiedad para el segundo nombre.
	 */
	public static final String LAST_NAME_PROPERTY = "lastname";
	/**
	 * Propiedad para el nombre de la tabla "author_writter".
	 */
	public static final String CATEGORIES_BOOKS_TABLE = "categories_books";
	/**
	 * Propiedad para el campo "authorcategory_id_id".
	 */
	public static final String CATEGORY_ID_FIELD = "category_id";
	/**
	 * Propiedad para el nombre de la tabla "publishers".
	 */
	public static final String PUBLISHERS_TABLE = "publishers";
	/**
	 * Propiedad para el campo "publisher_id".
	 */
	public static final String PUBLISHER_ID_FIELD = "publisher_id";
	/**
	 * Nombre de relacion entre libros y editoriales.
	 */
	public static final String PUBLISHER_BOOK_RELATIONSHIP = "publisher";


	/**
	 * Constructor de la clase.
	 */
	private PostgresConstant() {
	}
}
