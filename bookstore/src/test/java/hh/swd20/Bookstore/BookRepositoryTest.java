package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repo;
	
	@Test
	public void saveBook() throws Exception{
		Book book = new Book("Perikato", "Ilkka Remes", 2018, "954677364", 45.89, null);
		repo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	

	@Test
	public void findByTitle() throws Exception{
		Book book = new Book("Perikato", "Ilkka Remes", 2018, "954677364", 45.89, null);
		repo.save(book);
		assertThat(repo.findByTitle("Perikato")).isNotEmpty();
	}
}
