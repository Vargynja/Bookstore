package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bkrepo, CategoryRepository catrepo, UserRepository urepo) {
		return(args) -> {
			log.info("add 3 categories");
			catrepo.save(new Category("Fantasy"));
			catrepo.save(new Category("Thriller"));
			catrepo.save(new Category("Non-fiction"));
			
			log.info("add 2 books");
			bkrepo.save(new Book("Lord of The Rings", "J.R.R. Tolkien", 1932, "ANF4", 45, catrepo.findByName("Fantasy").get(0)));
			bkrepo.save(new Book("Sysilouhien sukua", "Ilkka Auer", 2004, "fe", 25.99, catrepo.findByName("Fantasy").get(0)));
			
			log.info("fetch books");
			
			for (Book book : bkrepo.findAll()) {
				log.info(book.toString());
			}
			
			log.info("add users");
			User user1 = new User("user","$2a$10$LTSKPt1JXGE5XSF5HQnHa.Gvj4T6IGms4B3sF3KUA7hrfo8jLKjoe", "gjag", "USER");
			User user2 = new User("admin","$2a$10$FkneFIYR6qF/zTFy6Iq1jOMXlApALF9/LMbuNxA85J0zk6gF4cgEq", "ghga", "ADMIN");
			
			urepo.save(user1);
			urepo.save(user2);
		};
	}

}

