package com.sdw.library.repository;

import com.sdw.library.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Felipe Monzón
 * @date: 4 ene. 2021
 * @version: 1.0.0
 */
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
