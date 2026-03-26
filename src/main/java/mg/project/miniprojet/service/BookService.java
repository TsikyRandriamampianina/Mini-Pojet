package mg.project.miniprojet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


import mg.project.miniprojet.model.Book;
import mg.project.miniprojet.repository.BookRepository;


@Service
public class BookService {


   @Autowired
   private BookRepository repository;


   public Book save(Book book) {
       return repository.save(book);
   }


   public List<Book> findAll() {
       return repository.findAll();
   }
}
