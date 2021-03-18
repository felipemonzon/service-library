package com.sdw.library.entity;

import com.sdw.library.constant.PostgresConstant;

import lombok.Data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @description: Entidad auditora.
 * @author: Felipe Monzón
 * @date: 8 dic. 2020
 * @version: 1.0.0
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<U> {
  /**
   * Usuario que crea el registro.
   */
  @CreatedBy
  @Column(name = PostgresConstant.CREATE_USER, updatable = false, nullable = false)
  protected U createdBy;
  /**
   * Fecha de creación.
   */
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = PostgresConstant.CREATE_DATE, updatable = false, nullable = false)
  protected Date createdDate;
  /**
   * Usuario que modifica el registro.
   */
  @LastModifiedBy
  @Column(name = PostgresConstant.LAST_MODIFIED_USER, nullable = false)
  protected U lastModifiedBy;
  /**
   * Fecha que modifica.
   */
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = PostgresConstant.LAST_MODIFIED_DATE, nullable = false)
  protected Date lastModifiedDate;
}
