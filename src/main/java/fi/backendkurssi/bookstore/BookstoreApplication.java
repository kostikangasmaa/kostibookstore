package fi.backendkurssi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.backendkurssi.bookstore.domain.Book;
import fi.backendkurssi.bookstore.domain.BookRepository;
import fi.backendkurssi.bookstore.domain.Category;
import fi.backendkurssi.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

  @Bean
    public CommandLineRunner bookdemo(BookRepository repository, CategoryRepository crepository) {
        return (args) -> {

            Category category1 = new Category("Jänskäri");
            Category category2 = new Category("Keittokirja");
            Category category3 = new Category("Lastenkirja");
            Category category4 = new Category("Kauhutarina");

            crepository.save(category1);
            crepository.save(category2);
            crepository.save(category3);
            crepository.save(category4);
            

            repository.save(new Book("Jep", "Kosti", "1234", 9.99, 2004, category1));
        };
    }
}
