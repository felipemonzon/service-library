package com.sdw.library.entity;

import com.sdw.library.constant.PostgresConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @description: Entidad para usuario.
 * @author: Felipe Monzón
 * @date: 8 dic. 2020
 * @version: 1.0.0
 */
@Data
@Entity(name = PostgresConstant.USERS_TABLE)
@Table(name = PostgresConstant.USERS_TABLE)
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class UserEntity extends AuditableEntity<String> {
	/**
	 * Identificador del usuario.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/**
	 * Propiedad primer nombre.
	 */
	@Column(name = "first_name", nullable = false)
	private String firstName;
	/**
	 * Propiedad segundo nombre.
	 */
	@Column(name = "last_name", nullable = false)
	private String lastName;
	/**
	 * Propiedad para el correo.
	 */
	@Column(name = "email_address", nullable = false)
	private String email;
	/**
	 * Propiedad para el celular.
	 */
	@Column(name = "cellphone", nullable = false)
	private String cel;
}
