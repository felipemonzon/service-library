package com.sdw.library.repository;

import com.sdw.library.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: Repositorio para la entidad de categoría.
 * @author: Felipe Monzón
 * @date: 2 mar. 2021
 * @version: 1.0.0
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
