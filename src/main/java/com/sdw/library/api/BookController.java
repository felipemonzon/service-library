package com.sdw.library.api;

import com.sdw.library.business.BookBusiness;
import com.sdw.library.constant.RoutesConstant;
import com.sdw.library.entity.BookEntity;
import com.sdw.library.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description:
 * @author: Felipe Monzón
 * @date: 4 ene. 2021
 * @version: 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RoutesConstant.BASE_PATH)
public class BookController {
	private final BookBusiness bookBusiness;

	@PostMapping(path = RoutesConstant.BOOKS_SAVE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookEntity> save(@RequestBody @Valid Book request) {
		return ResponseEntity.ok(this.bookBusiness.saveBook(request));
	}

	@GetMapping(path = RoutesConstant.BOOKS_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> retrieve() {
		return ResponseEntity.ok(this.bookBusiness.retrieve());
	}
}
