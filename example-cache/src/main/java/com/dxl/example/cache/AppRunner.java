package com.dxl.example.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Program AppRunner
 * @Description
 * @Author duxl
 * @Create 2018/11/15 9:12
 */
@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(AppRunner.class);
	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) {
		log.info("start.....");
		log.info("isbn:1234 ----->" + bookRepository.getByIsbn("isbn:1234"));
		log.info("isbn:1357 ----->" + bookRepository.getByIsbn("isbn:1357"));
		log.info("isbn:2345 ----->" + bookRepository.getByIsbn("isbn:2345"));
		log.info("isbn:6543 ----->" + bookRepository.getByIsbn("isbn:6543"));
		log.info("isbn:7234 ----->" + bookRepository.getByIsbn("isbn:7234"));
		log.info("(by cache)isbn:1234 ----->" + bookRepository.getByIsbn("isbn:1234"));
	}
}
