package com.sdw.library.entity;

import com.sdw.library.constant.PostgresConstant;
import com.sdw.library.utilities.Status;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

/**
 * Entidad para libros.
 *
 * @author: Felipe Monzón
 * @date: 4 ene. 2021
 * @version: 1.0.0
 */
@Data
@Entity(name = PostgresConstant.BOOKS_TABLE)
@Table(name = PostgresConstant.BOOKS_TABLE)
public class BookEntity {
	/**
	 * Identificador del libro.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * Nombre del libro.
	 */
	@Column(name = PostgresConstant.BOOK_TITLE_FIELD, unique = true)
	private String title;
	/**
	 * ISBN.
	 */
	@NaturalId
	private String isbn;
	/**
	 * Estatus del libro.
	 */
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	/**
	 * Relación con la tabla de autores.
	 */
	@ManyToMany
	@JoinTable(name = PostgresConstant.AUTHOR_WRITTER_TABLE,
					joinColumns = @JoinColumn(name = PostgresConstant.BOOK_ID_FIELD),
					inverseJoinColumns = @JoinColumn(name = PostgresConstant.AUTHOR_ID_FIELD))
	@Column(name = PostgresConstant.AUTHOR_ID_FIELD, nullable = false)
	private Set<AuthorEntity> authors;
	/**
	 * Relación con la tabla de categorías.
	 */
	@ManyToMany
	@JoinTable(name = PostgresConstant.CATEGORIES_BOOKS_TABLE,
					joinColumns = @JoinColumn(name = PostgresConstant.BOOK_ID_FIELD),
					inverseJoinColumns = @JoinColumn(name = PostgresConstant.CATEGORY_ID_FIELD))
	@Column(name = PostgresConstant.CATEGORY_ID_FIELD, nullable = false)
	private Set<CategoryEntity> categories;
	/**
	 * Editorial del libro.
	 */
	@ManyToOne
	@JoinColumn(name = PostgresConstant.PUBLISHER_ID_FIELD, referencedColumnName = PostgresConstant.PUBLISHER_ID_FIELD)
	private PublisherEntity publisher;
}
