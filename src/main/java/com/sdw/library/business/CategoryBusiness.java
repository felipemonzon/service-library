package com.sdw.library.business;

import com.sdw.library.constant.LogConstant;
import com.sdw.library.entity.CategoryEntity;
import com.sdw.library.exception.custom.NoDataFoundException;
import com.sdw.library.model.Category;
import com.sdw.library.model.response.CategoriesResponse;
import com.sdw.library.repository.CategoryRepository;
import com.sdw.library.service.CategoryService;
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
 * Implementación de las APIS de categoría.
 *
 * @author Felipe Monzón
 * @version 1.0.0
 * @date 2 mar. 2021
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryBusiness implements CategoryService {
	/**
	 * Repositorio de categorías.
	 */
	private final CategoryRepository categoryRepository;

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Transactional
	public void save(Category request) {
		log.debug(LogConstant.REQUEST, request.toString());
		this.categoryRepository.save(this.mapping(request));
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Transactional(readOnly = true)
	public CategoriesResponse retrieve(Pageable pageable) {
		log.debug(LogConstant.CATEGORY_RETREVE);
		int currentPage = Utilities.getCurrentPage(pageable);
		Page<Category> categories = this.categoryRepository.findAll(PageRequest.of(currentPage, pageable.getPageSize())).
						map(this::mapping);
		return CategoriesResponse.builder().categories(categories.getContent()).totalPages(categories.getTotalPages())
						.currentPage(currentPage).firstPage(categories.isFirst()).lastPage(categories.isLast()).build();
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@Modifying
	@Transactional
	public void replaceCategory(Category request, int id) {
		log.debug(LogConstant.REQUEST, request.toString());
		this.categoryRepository.findById(id).map(pub -> {
			pub.setName(request.getName());
			pub.setStatus(Status.valueOf(request.getStatus()));
			return this.categoryRepository.save(pub);
		}).<NoDataFoundException>orElseThrow(() -> {
			throw new NoDataFoundException(LogConstant.NO_DATA);
		});
	}

	/**
	 * Convierte un objeto {@code Category} a una entidad de tipo {@code CategoryEntity}
	 *
	 * @param request objeto de tipo {@link Category}
	 * @return una entidad de categoría
	 */
	private CategoryEntity mapping(Category request) {
		return new ModelMapper().map(request, CategoryEntity.class);
	}

	/**
	 * Convierte una entidad {@code CategoryEntity} a uno de tipo {@code Publisher}
	 *
	 * @param entity objeto de tipo {@link Category}
	 * @return objeto de salida de la api de categorías
	 */
	private Category mapping(CategoryEntity entity) {
		return new ModelMapper().map(entity, Category.class);
	}
}
