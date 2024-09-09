package fi.backendkurssi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.backendkurssi.bookstore.domain.Book;
import fi.backendkurssi.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

  @Bean
    public CommandLineRunner bookdemo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book("Jep", "Kosti", "1234", 9.99, 2004));
        };
    }
}
