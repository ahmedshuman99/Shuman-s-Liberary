package com.Shuman.s.Project.Shuman.s.Liberary.Controller;

import com.Shuman.s.Project.Shuman.s.Liberary.Model.Entities.BookEntity;
import com.Shuman.s.Project.Shuman.s.Liberary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/get_book")
    public Optional<BookEntity> getBook(@RequestParam Integer id) {
        return bookService.getBook(id);
    }

    @PostMapping("/add")
    public BookEntity add(@RequestBody BookEntity bookEntity){
        return this.bookService.add(bookEntity);
    }

    @PostMapping("/delete")
    public BookEntity delete(@RequestParam Integer id){
        return this.bookService.delete(id);
    }

    @PostMapping("/update")
    public BookEntity update(@RequestBody BookEntity bookEntity , @RequestParam Integer id){
        return this.bookService.update(id, bookEntity);
    }
    @GetMapping("/get_all")
    public List<BookEntity>getAll(){
        List<BookEntity>list = this.bookService.getAllBooks();
        return list;
    }

    @GetMapping("/delete_all")
    public List<BookEntity> deleteAllBooks(){
        return this.bookService.deleteAllBooks();
    }

}
