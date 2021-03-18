package com.sdw.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sdw.library.constant.PostgresConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @description: Entidad para editorial.
 * @author: Felipe Monzón
 * @date: 4 ene. 2021
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = PostgresConstant.PUBLISHERS_TABLE)
@Table(name = PostgresConstant.PUBLISHERS_TABLE)
public class PublisherEntity {
	/**
	 * Identificador de editoriales.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = PostgresConstant.PUBLISHER_ID_FIELD, nullable = false, unique = true, updatable = false)
	private int id;
	/**
	 * Nombre de la editorial.
	 */
	@Column(name = PostgresConstant.DESCRIPTION_FIELD, nullable = false, unique = true)
	private String name;
	/**
	 * libros de la editorial.
	 */
	@JsonIgnore
	@OneToMany(mappedBy = PostgresConstant.PUBLISHER_BOOK_RELATIONSHIP, orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<BookEntity> books;
}
