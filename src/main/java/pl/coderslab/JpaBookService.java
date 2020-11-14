package pl.coderslab;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaBookService implements BookService{
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook;
    }
    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }
    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    @Override
    public void update(Book book) {
    bookRepository.save(book);
    }
}
