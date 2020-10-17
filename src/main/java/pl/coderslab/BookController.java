package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MemoryBookService memoryBookService;
    @Autowired
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
        return memoryBookService.getList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable String id){
        return memoryBookService.getList().get(Integer.parseInt(id) - 1);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        book.setId(memoryBookService.getNextId());
        memoryBookService.setNextId();
        memoryBookService.getList().add(book);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book){

        if (memoryBookService.getList().size() <= book.getId() - 1){
            Long bookId = book.getId() - 1;
            memoryBookService.getList().set(bookId.intValue(), book);
        }


    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        memoryBookService.getList().remove(Integer.parseInt(id) -1);
    }

}
