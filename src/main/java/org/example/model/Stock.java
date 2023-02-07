import jakarta.persistence.*;
import org.example.model.Book;
import org.example.model.Store;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private Integer quantity;

    // Getters and setters
}