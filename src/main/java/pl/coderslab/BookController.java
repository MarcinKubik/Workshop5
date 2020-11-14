package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;

    public BookController(MemoryBookService memoryBookService){
        this.memoryBookService = memoryBookService;
    }
    @RequestMapping(value = "/helloBook", method = RequestMethod.GET)
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> books(){
        return memoryBookService.getBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable String id){
        return memoryBookService.getBooks().get(Integer.parseInt(id) - 1);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
      memoryBookService.add(book);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book){

        if (memoryBookService.getBooks().size() <= book.getId() - 1){
            Long bookId = book.getId() - 1;
            memoryBookService.getBooks().set(bookId.intValue(), book);
        }


    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        memoryBookService.getBooks().remove(Integer.parseInt(id) -1);
    }

}
