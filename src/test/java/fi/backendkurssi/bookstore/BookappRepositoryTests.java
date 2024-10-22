package fi.backendkurssi.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.backendkurssi.bookstore.domain.Book;
import fi.backendkurssi.bookstore.domain.BookRepository;
import fi.backendkurssi.bookstore.domain.Category;
import fi.backendkurssi.bookstore.domain.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Optional;

@DataJpaTest
public class BookappRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateBook() {
        Category category = new Category("Science Fiction");
        categoryRepository.save(category);
        
        Book book = new Book("Isaac Asimov", "Foundation", "9781234567897", 29.99, 1951, category);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
        assertThat(bookRepository.findById(book.getId())).isPresent();
    }

    @Test
    public void testFindBookById() {
        Category category = new Category("Fantasy");
        categoryRepository.save(category);

        Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", "9781234567897", 49.99, 1954, category);
        bookRepository.save(book);

        Optional<Book> foundBook = bookRepository.findById(book.getId());
        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getTitle()).isEqualTo("The Lord of the Rings");
    }

    @Test
    public void testDeleteBook() {
        Category category = new Category("Mystery");
        categoryRepository.save(category);

        Book book = new Book("Agatha Christie", "Murder on the Orient Express", "9781234567897", 19.99, 1934, category);
        bookRepository.save(book);

        bookRepository.deleteById(book.getId());
        Optional<Book> deletedBook = bookRepository.findById(book.getId());

        assertThat(deletedBook).isNotPresent();
    }

  
}
