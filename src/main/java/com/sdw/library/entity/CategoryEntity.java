package com.sdw.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sdw.library.constant.PostgresConstant;
import com.sdw.library.utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

/**
 * @description: Entidad para la tabla de categorías.
 * @author: Felipe Monzón
 * @date: 2 mar. 2021
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = PostgresConstant.CATEGORIES_TABLE)
@Table(name = PostgresConstant.CATEGORIES_TABLE)
public class CategoryEntity {
	/**
	 * Identificador de la categorías.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = PostgresConstant.CATEGORY_ID_FIELD)
	private int id;
	/**
	 * Nombre de la categorías.
	 */
	@NaturalId(mutable = true)
	@Column(name = PostgresConstant.DESCRIPTION_FIELD, unique = true, nullable = false)
	private String name;
	/**
	 * Estatus de la categorías.
	 */
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	/**
	 * Relación para la tabla de libros.
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = PostgresConstant.CATEGORIES_TABLE)
	private Set<BookEntity> books;
}
