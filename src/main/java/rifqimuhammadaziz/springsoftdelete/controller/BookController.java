package rifqimuhammadaziz.springsoftdelete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springsoftdelete.entity.Book;
import rifqimuhammadaziz.springsoftdelete.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        bookService.delete(id);
    }
}
