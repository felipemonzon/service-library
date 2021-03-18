package com.sdw.library.business;

import com.sdw.library.constant.LogConstant;
import com.sdw.library.entity.UserEntity;
import com.sdw.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description: Implementacion de las reglas de negocio para el modulo de usuarios.
 * @author: Felipe Monzón
 * @date: 8 dic. 2020
 * @version: 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserBusiness {
	/**
	 * Repositorio de usuarios.
	 */
	private final UserRepository userRepository;

	public UserEntity save(UserEntity request) {
		log.debug(LogConstant.REQUEST, request.toString());
		return this.userRepository.save(request);
	}
}
