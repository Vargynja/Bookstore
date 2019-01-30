package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bkrepo) {
		return(args) -> {
			bkrepo.save(new Book("Lord of The Rings", "J.R.R. Tolkien", 1932, "ANF4", 45));
			bkrepo.save(new Book("Sysilouhien sukua", "Ilkka Auer", 2004, "fe", 25.99));
		};
	}

}

