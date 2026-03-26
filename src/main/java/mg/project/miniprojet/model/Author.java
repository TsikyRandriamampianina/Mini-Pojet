package mg.project.miniprojet.model;


import jakarta.persistence.*;
import java.util.List;


@Entity
public class Author {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   private String name;


   @ManyToMany(mappedBy = "authors")
   private List<Book> books;


   public Author() {}


   public Long getId() { return id; }
   public String getName() { return name; }
   public List<Book> getBooks() { return books; }


   public void setId(Long id) { this.id = id; }
   public void setName(String name) { this.name = name; }
   public void setBooks(List<Book> books) { this.books = books; }
}
