package pl.coderslab;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService{
    private List<Book> books;
    private static Long nextId = 4L;
    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766","Thiniking in Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public void add(Book book){
        book.setId(nextId++);
        books.add(book);
    }



    public List<Book> getBooks(){
        return books;
    }

    public Long getNextId(){
        return nextId;
    }

    public void setNextId(){
        nextId += 1;
    }
}
