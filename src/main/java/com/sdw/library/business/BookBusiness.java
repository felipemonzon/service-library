package com.sdw.library.business;

import com.sdw.library.constant.LogConstant;
import com.sdw.library.entity.BookEntity;
import com.sdw.library.model.Book;
import com.sdw.library.repository.BookRepository;
import com.sdw.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Implementación de las reglas de negocio.
 * @author: Felipe Monzón
 * @date: 4 ene. 2021
 * @version: 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookBusiness implements BookService {
	/**
	 * Repositorio de libros.
	 */
	private final BookRepository bookRepository;

	/**
	 * Guarda un libro.
	 *
	 * @param request {@link Book}
	 */
	@Override
	public BookEntity saveBook(Book request) {
		log.debug(LogConstant.REQUEST, request.toString());
		return this.bookRepository.save(this.bookMapping(request));
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	public List<Book> retrieve() {
		return this.bookRepository.findAll().stream().map(this::bookMapping).collect(Collectors.toList());
	}

	/**
	 * Convierte un objeto {@code BookDto} a una entidad de tipo {@code BookEntity}
	 *
	 * @param request objeto de tipo {@link Book}
	 * @return una entidad de libros
	 */
	private BookEntity bookMapping(Book request) {
		return new ModelMapper().map(request, BookEntity.class);
	}

	/**
	 * Convierte una entidad {@code BookEntity} a uno de tipo {@code BookDto}
	 *
	 * @param entity objeto de tipo {@link BookEntity}
	 * @return objeto de salida de la api de libros
	 */
	private Book bookMapping(BookEntity entity) {
		return new ModelMapper().map(entity, Book.class);
	}
}
