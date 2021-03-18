package com.sdw.library.exception;

import com.sdw.library.constant.ApiConstant;
import com.sdw.library.exception.custom.BadRequestException;
import com.sdw.library.exception.custom.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Administrador de excepciones.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 12/03/21
 */
@Slf4j
@RestControllerAdvice
public class ExceptionManagment {
	/**
	 * Enumerator for errors.
	 */
	public enum ErrorType {
		ERROR, WARN, INVALID, FATAL
	}

	/**
	 * Maneja una excepción de tipo BadRequestException.
	 *
	 * @param req Objeto HttpServlet de petición.
	 * @param ex  Excepción recibida BadRequestException.
	 * @return errorResponse Objeto de respuesta específica para BadRequestException.
	 */
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveBadRequestException(HttpServletRequest req, BadRequestException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		String moreInfo = null;

		if (ObjectUtils.isEmpty(ex.getBadFields())) {
			moreInfo = String.join(ApiConstant.COMMA, ex.getBadFields());
		}

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(ex.getMessage());
		errorResponse.setDetails(ex.getMessage());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setMoreInfo(moreInfo);
		errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
		errorResponse.setTimestamp(ZonedDateTime.now());

		log.error(errorResponse.toString());

		return errorResponse;
	}

	/**
	 * Maneja una excepción de tipo {@link MethodArgumentNotValidException}.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida MethodArgumentNotValidException.
	 * @return errorResponse Objeto de respuesta específica para MethodArgumentNotValidException.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
	                                                            MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

		List<String> fields = new ArrayList<>();
		Map<String, List<String>> groupedErrors = new HashMap<>();

		for (FieldError fieldError : fieldErrors) {
			String field = fieldError.getField();
			groupedErrors.computeIfAbsent(fieldError.getDefaultMessage(), key -> Collections.singletonList(field));
			fields.add(field);
		}
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(ex.getMessage());
		errorResponse.setDetails(groupedErrors.toString());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setMoreInfo(fields.toString());
		errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
		errorResponse.setTimestamp(ZonedDateTime.now());

		log.error(errorResponse.toString());
		return errorResponse;
	}

	/**
	 * Maneja una excepción de tipo {@code DataIntegrityViolationException} generada por excepciones SQL.
	 *
	 * @param req Petición
	 * @param ex  excepción generada por JPA
	 * @return objeto de respuesta especifico para {@see DataIntegrityViolationException}
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ErrorResponse resolveDataIntegrityViolationException(HttpServletRequest req, DataIntegrityViolationException ex) {
		String error = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();

		String[] message = Arrays.stream(error.split("[:]")).map(String::trim).toArray(String[]::new);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setType(ErrorType.FATAL.name());
		errorResponse.setCode(HttpStatus.CONFLICT.name());
		errorResponse.setDetails(message[2]);
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setMoreInfo(message[1].replace("Detail", StringUtils.EMPTY).trim());
		errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
		errorResponse.setTimestamp(ZonedDateTime.now());

		log.error(errorResponse.toString());
		return errorResponse;
	}
}
