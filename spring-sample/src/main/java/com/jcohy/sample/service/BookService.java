package com.jcohy.sample.service;

import com.jcohy.sample.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookService {

	// @Qualifier("bookDao")
	// @Autowired(required=false)
	// @Resource(name="bookDao2")
	@Inject
	private BookDao bookDao;

	public void print() {
		System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}

}
