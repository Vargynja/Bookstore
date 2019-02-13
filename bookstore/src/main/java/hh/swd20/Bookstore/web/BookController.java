package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.*;

@Controller
public class BookController {

	@Autowired
	private BookRepository bkrepo;
	
	@Autowired
	private CategoryRepository catrepo;

	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	// REST service all books
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) bkrepo.findAll();
	}
	
	//REST sevice book by id
	@GetMapping("/book/{id}")
	public @ResponseBody Optional<Book> findBookById(@PathVariable("id") Long id){
		return bkrepo.findById(id);
	}

	@GetMapping("/booklist")
	public String getBooklist(Model model) {
		model.addAttribute("books", bkrepo.findAll());
		return "booklist";
	}

	@RequestMapping("/addbook")
	public String createBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catrepo.findAll());
		return "addbook";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute("book") Book book) {
		bkrepo.save(book);
		return "redirect:booklist";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bkrepo.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book",bkrepo.findById(bookId).get());
		model.addAttribute("categories", catrepo.findAll());
		return "editbook";
	}
	

}
