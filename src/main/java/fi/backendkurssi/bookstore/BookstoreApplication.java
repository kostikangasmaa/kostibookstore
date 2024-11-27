package fi.backendkurssi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.backendkurssi.bookstore.domain.Book;
import fi.backendkurssi.bookstore.domain.BookRepository;
import fi.backendkurssi.bookstore.domain.Category;
import fi.backendkurssi.bookstore.domain.CategoryRepository;
import fi.backendkurssi.bookstore.domain.User;
import fi.backendkurssi.bookstore.domain.UserRepository;;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

  @Bean
    public CommandLineRunner bookdemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
        return (args) -> {

            Category category1 = new Category("Jänskäri");
            Category category2 = new Category("Keittokirja");
            Category category3 = new Category("Lastenkirja");
            Category category4 = new Category("Kauhutarina");

            crepository.save(category1);
            crepository.save(category2);
            crepository.save(category3);
            crepository.save(category4);

            User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "lol@jusju.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "kostionparas@jepjuu.fi");
			//urepository.save(user1);
			//urepository.save(user2);
            

            repository.save(new Book("Jep", "Kosti", "1234", 9.99, 2004, category1));
        };
    }
}
