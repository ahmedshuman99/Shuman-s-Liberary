package com.Shuman.s.Project.Shuman.s.Liberary.Service;

import com.Shuman.s.Project.Shuman.s.Liberary.Model.Entities.BookEntity;
import com.Shuman.s.Project.Shuman.s.Liberary.Model.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<BookEntity> getBook(Integer id){
        Optional<BookEntity> book = this.bookRepository.findById(id);
        if (book.isPresent())
            return Optional.of(book.get());
        return null;
    }

    public BookEntity add(BookEntity bookEntity){
        return this.bookRepository.save(bookEntity);

    }

    public BookEntity delete(Integer id){
        BookEntity bookEntityToDelete = this.bookRepository.findById(id).orElse(null);
        if (bookEntityToDelete != null) {
            this.bookRepository.deleteById(id);
        }
        return bookEntityToDelete;
    }

    public BookEntity update(Integer id , BookEntity bookEntity){
        BookEntity bookEntityToUpdate = this.bookRepository.findById(id).orElse(null);
        if (bookEntityToUpdate != null) {
            bookEntity.setId(id); // Ensure that the provided bookEntity has the correct ID
            this.bookRepository.save(bookEntity);
        }

        return bookEntityToUpdate;
    }


    public List<BookEntity>getAllBooks(){
        List<BookEntity>list = this.bookRepository.findAll();
        return list;
    }

    public List<BookEntity> deleteAllBooks(){
        List<BookEntity> deletedBooks = new ArrayList<>();
        Iterable<BookEntity> booksToDelete = this.bookRepository.findAll();
        booksToDelete.forEach(deletedBooks::add);
        this.bookRepository.deleteAll();
        return deletedBooks;
    }



}
