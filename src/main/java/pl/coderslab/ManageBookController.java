package pl.coderslab;

import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("book", new Book());
        return "/books/form";
    }

    @GetMapping("/get/{id}")
    public String showBook(@PathVariable Long id, Model model){
        Optional<Book> optionalBook = bookService.get(id);
        Book book = optionalBook.orElseThrow(() -> new NoSuchElementException("No such element"));
        model.addAttribute("book", book);
        return "/books/book";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Optional<Book> optionalBook = bookService.get(id);
        Book book = optionalBook.orElseThrow(() -> new NoSuchElementException("No such element"));
        model.addAttribute("book", book);
        return "/books/form";
    }

    @PostMapping("/addEdit")
    public String addEdit(@Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "books/form";
        }
        if (book.getId() == null){
            bookService.add(book);
        }else{
            bookService.update(book);
        }

        return "redirect:/admin/books/all";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }
}
