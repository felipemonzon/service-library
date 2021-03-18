package com.sdw.library.business;

import com.sdw.library.constant.LogConstant;
import com.sdw.library.entity.AuthorEntity;
import com.sdw.library.exception.custom.NoDataFoundException;
import com.sdw.library.model.Author;
import com.sdw.library.model.response.AuthorsResponse;
import com.sdw.library.repository.AuthorRepository;
import com.sdw.library.service.AuthorService;
import com.sdw.library.utilities.Status;
import com.sdw.library.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación de las APIS de autores.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 17 feb. 2021
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorBusiness implements AuthorService {
	/**
	 * Repositorio para autores.
	 */
	private final AuthorRepository authorRepository;

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Transactional(readOnly = true)
	public AuthorsResponse retrieve(Pageable pageable) {
		int currentPage = Utilities.getCurrentPage(pageable);
		Page<Author> authors = this.authorRepository.findAll(PageRequest.of(currentPage, pageable.getPageSize())).map(this::mapping);
		return AuthorsResponse.builder().authors(authors.getContent()).totalPages(authors.getTotalPages()).
						currentPage(currentPage).firstPage(authors.isFirst()).lastPage(authors.isLast()).build();
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Transactional
	public void saveAuthor(Author request) {
		log.debug(LogConstant.REQUEST, request.toString());
		this.authorRepository.save(this.mapping(request));
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Modifying
	@Transactional
	public void replaceAuthor(Author request, Long id) {
		log.debug(LogConstant.REQUEST, request.toString());
		this.authorRepository.findById(id).map(au -> {
			au.setFirstName(request.getFirstName());
			au.setLastName(request.getLastName());
			au.setStatus(Status.valueOf(request.getStatus()));
			return this.authorRepository.save(au);
		}).<NoDataFoundException>orElseThrow(() -> {
			throw new NoDataFoundException(LogConstant.NO_DATA);
		});
	}

	/**
	 * Convierte un objeto {@code Author} a una entidad de tipo {@code AuthorEntity}
	 *
	 * @param request objeto de tipo {@link Author}
	 * @return una entidad de autores
	 */
	private AuthorEntity mapping(Author request) {
		return new ModelMapper().map(request, AuthorEntity.class);
	}

	/**
	 * Convierte una entidad {@code AuthorEntity} a uno de tipo {@code Author}
	 *
	 * @param entity objeto de tipo {@link AuthorEntity}
	 * @return objeto de salida de la api de autores
	 */
	private Author mapping(AuthorEntity entity) {
		return new ModelMapper().map(entity, Author.class);
	}
}
