package com.sdw.library.business;

import com.sdw.library.constant.LogConstant;
import com.sdw.library.entity.PublisherEntity;
import com.sdw.library.exception.custom.NoDataFoundException;
import com.sdw.library.model.Publisher;
import com.sdw.library.repository.PublisherRepository;
import com.sdw.library.service.PublisherService;
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
 * @description: Implementación de las reglas de negocio.
 * @author: Felipe Monzón
 * @date: 7 mar. 2021
 * @version: 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PublisherBusiness implements PublisherService {
	/**
	 * Repositorio para editoriales.
	 */
	private final PublisherRepository publisherRepository;

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Transactional
	public void save(Publisher request) {
		log.debug(LogConstant.REQUEST, request.toString());
		this.publisherRepository.save(this.mapping(request));
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Modifying
	@Transactional
	public void replacePublisher(Publisher request, int id) {
		log.debug(LogConstant.REQUEST, request.toString());
		this.publisherRepository.findById(id).map(pub -> {
			pub.setName(request.getName());
			return this.publisherRepository.save(pub);
		}).<NoDataFoundException>orElseThrow(() -> {
			throw new NoDataFoundException(LogConstant.NO_DATA);
		});
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<Publisher> retrieve(Pageable pageable) {
		int page = Utilities.getCurrentPage(pageable);
		return this.publisherRepository.findAll(PageRequest.of(page, pageable.getPageSize())).map(this::mapping);
	}

	/**
	 * Convierte un objeto {@code Publisher} a una entidad de tipo {@code PublisherEntity}
	 *
	 * @param request objeto de tipo {@link Publisher}
	 * @return una entidad de editorial
	 */
	private PublisherEntity mapping(Publisher request) {
		return new ModelMapper().map(request, PublisherEntity.class);
	}

	/**
	 * Convierte una entidad {@code PublisherEntity} a uno de tipo {@code Publisher}
	 *
	 * @param entity objeto de tipo {@link Publisher}
	 * @return objeto de salida de la api de editorial
	 */
	private Publisher mapping(PublisherEntity entity) {
		return new ModelMapper().map(entity, Publisher.class);
	}
}
