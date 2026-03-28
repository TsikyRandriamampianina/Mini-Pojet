package mg.project.miniprojet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


import mg.project.miniprojet.model.Book;
import mg.project.miniprojet.service.BookService;

import org.springframework.hateoas.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


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
    public List<EntityModel<Book>> getAll() {


    List<Book> books = service.findAll();


    return books.stream().map(book -> {


        EntityModel<Book> model = EntityModel.of(book);


        model.add(linkTo(methodOn(BookController.class)
                .getAll()).withRel("all-books"));


        model.add(linkTo(methodOn(BookController.class)
                .getOne(book.getId())).withSelfRel());


        return model;


    }).toList();
    }


   @GetMapping("/top")
    public List<Map<String, Object>> topBooks() {
    return service.getTopBooks();
    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable Long id) {
        return service.findById(id);
    }

}


