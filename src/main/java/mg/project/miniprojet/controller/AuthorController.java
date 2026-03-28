package mg.project.miniprojet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import mg.project.miniprojet.model.Author;
import mg.project.miniprojet.service.AuthorService;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {


   @Autowired
   private AuthorService service;


   @PostMapping
   public Author create(@RequestBody Author author) {
       return service.save(author);
   }


   @GetMapping
   public List<Author> getAll() {
       return service.findAll();
   }
}
