package mg.project.miniprojet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


import mg.project.miniprojet.model.Author;
import mg.project.miniprojet.repository.AuthorRepository;


@Service
public class AuthorService {


   @Autowired
   private AuthorRepository repository;
      public Author save(Author author) {
       return repository.save(author);
   }


   public List<Author> findAll() {
       return repository.findAll();
   }
}
