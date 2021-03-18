package com.sdw.library.repository;

import com.sdw.library.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: Repositorio de usuarios.
 * @author: Felipe Monzón
 * @date: 8 dic. 2020
 * @version: 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
