package com.sdw.library.repository;

import com.sdw.library.entity.PublisherEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: Repositorio para editoriales.
 * @author: Felipe Monzón
 * @date: 7 mar. 2021
 * @version: 1.0.0
 */
@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Integer> {

}
