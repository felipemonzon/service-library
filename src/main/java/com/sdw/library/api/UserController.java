package com.sdw.library.api;

import com.sdw.library.business.UserBusiness;
import com.sdw.library.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description:
 * @author: Felipe Monzón
 * @date: 8 dic. 2020
 * @version: 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {
	/**
	 * Servicio de usuarios.
	 */
	private final UserBusiness userBusiness;

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> save(@RequestBody @Valid UserEntity request) {
		return ResponseEntity.ok(this.userBusiness.save(request));
	}
}
