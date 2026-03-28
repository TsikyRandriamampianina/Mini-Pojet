package mg.project.miniprojet.model;


import jakarta.persistence.*;
import java.util.List;


@Entity
public class Book {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   private String title;
   private String description;


   @ManyToOne
   private Category category;


   @ManyToMany
   @JoinTable(
       name = "book_author",
       joinColumns = @JoinColumn(name = "book_id"),
       inverseJoinColumns = @JoinColumn(name = "author_id")
   )
   private List<Author> authors;


   public Book() {}


   public Long getId() { return id; }
   public String getTitle() { return title; }
   public String getDescription() { return description; }
   public Category getCategory() { return category; }
   public List<Author> getAuthors() { return authors; }


   public void setId(Long id) { this.id = id; }
   public void setTitle(String title) { this.title = title; }
   public void setDescription(String description) { this.description = description; }
   public void setCategory(Category category) { this.category = category; }
   public void setAuthors(List<Author> authors) { this.authors = authors; }
}
