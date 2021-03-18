package com.sdw.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sdw.library.constant.PostgresConstant;
import com.sdw.library.utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @description: Entidad de autores.
 * @author: Felipe Monzón
 * @date: 8 dic. 2020
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = PostgresConstant.AUTHORS_TABLE)
@Table(name = PostgresConstant.AUTHORS_TABLE)
public class AuthorEntity {
	/**
	 * Identificador de la tabla.
	 */
	@Id
	@Column(name = PostgresConstant.AUTHOR_ID_FIELD)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * Propiedad para el primer nombre del autor.
	 */
	@Column(name = PostgresConstant.FIRST_NAME_PROPERTY, nullable = false)
	private String firstName;
	/**
	 * Segundo nombre.
	 */
	@Column(name = PostgresConstant.LAST_NAME_PROPERTY, nullable = false)
	private String lastName;
	/**
	 * Status del autor.
	 */
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	/**
	 * Relación para la tabla de libros.
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = PostgresConstant.AUTHORS_TABLE, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<BookEntity> books;
}
