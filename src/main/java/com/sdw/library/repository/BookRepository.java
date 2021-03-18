package com.sdw.library.repository;

import com.sdw.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: Repositorio para la entidad de libros.
 * @author: Felipe Monzón
 * @date: 4 ene. 2021
 * @version: 1.0.0
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
