package com.libby.bookshelf.service;

import com.libby.bookshelf.exception.ResourceNotFoundException;
import com.libby.bookshelf.model.Book;
import com.libby.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id); // Ensure the provided book has the correct ID
            return bookRepository.save(book);
        } else {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
