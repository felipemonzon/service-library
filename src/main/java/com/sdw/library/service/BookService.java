package com.sdw.library.service;

import com.sdw.library.entity.BookEntity;
import com.sdw.library.model.Book;

import java.util.List;

/**
 * @description: Servicio de libros.
 * @author: Felipe Monzón
 * @date: 11/03/21
 * @version: 1.0.0
 */
public interface BookService {
	/**
	 * Guarda un libro.
	 *
	 * @param request {@link Book}
	 */
	BookEntity saveBook(Book request);

	/**
	 * Consulta los libros.
	 *
	 * @return una lista de tipo {@code BookDto}
	 */
	List<Book> retrieve();
}
