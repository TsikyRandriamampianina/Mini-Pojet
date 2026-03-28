package mg.project.miniprojet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Author {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   private String name;


   @JsonIgnore
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
