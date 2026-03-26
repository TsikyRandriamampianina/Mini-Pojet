package mg.project.miniprojet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import mg.project.miniprojet.model.Book;
import mg.project.miniprojet.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {


   @Autowired
   private BookService service;


   @PostMapping
   public Book create(@RequestBody Book book) {
       return service.save(book);
   }


   @GetMapping
   public List<Book> getAll() {
       return service.findAll();
   }
}
