package com.project.moviebooking.controller;

import com.project.moviebooking.model.Movie;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieRestController {
    // autowired : repo, service

    // CREATE NEW MOVIE
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> createNewMovie(@Valid @RequestBody Map<String, Object> movieMap){
        Movie newMovie = new Movie(movieMap.get("name").toString(),movieMap.get("description").toString());
        // save to database
        // repo.save(movie)

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Movie created successfully");
        response.put("movie", newMovie);
        return response;

    }



    // GET /{movieId} : get one movie by id
    @RequestMapping(method = RequestMethod.GET, value="/{movieId}")
    public Movie getMovieDetails(@PathVariable("movieId") String movieId){
//        return bookRepository.findOne(bookId);
        return null;

    }


    // update movie

import org.springframework.data.annotation.Id;

    public class Book {

        @Id
        private String id;
        private String name;
        private String isbn;
        private String author;
        private int pages;

        public Book(){}

        public Book(String name, String isbn, String author, int pages){
            this.name = name;
            this.isbn = isbn;
            this.author = author;
            this.pages = pages;
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getIsbn() {
            return isbn;
        }
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public int getPages() {
            return pages;
        }
        public void setPages(int pages) {
            this.pages = pages;
        }
    }

    Lets add Repository class to interact with the DB

            Recommended from our users: Dynamic Network Monitoring from WhatsUp Gold from IPSwitch. Free Download
package app.repository;

import app.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;

    public interface BookRepository extends MongoRepository<Book, String>{
    }
    The MongoRepository provides basic CRUD operation methods and also an API to find all documents in the collection.

    Implementing Create and Get Details API
    Lets implement our controller. First is the API to create new book and also to get the details of a given book:

            package app.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Book;
import app.repository.BookRepository;

    @RestController
    @RequestMapping("/book")
    public class BookController {

        @Autowired
        private BookRepository bookRepository;

        @RequestMapping(method = RequestMethod.POST)
        public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap){
            Book book = new Book(bookMap.get("name").toString(),
                    bookMap.get("isbn").toString(),
                    bookMap.get("author").toString(),
                    Integer.parseInt(bookMap.get("pages").toString()));

            bookRepository.save(book);
            Map<String, Object> response = new LinkedHashMap<String, Object>();
            response.put("message", "Book created successfully");
            response.put("book", book);
            return response;
        }

        @RequestMapping(method = RequestMethod.GET, value="/{bookId}")
        public Book getBookDetails(@PathVariable("bookId") String bookId){
            return bookRepository.findOne(bookId);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value="/{bookId}")
    public Map<String, Object> editBook(@PathVariable("bookId") String bookId,
                                        @RequestBody Map<String, Object> bookMap){
        Book book = new Book(bookMap.get("name").toString(),
                bookMap.get("isbn").toString(),
                bookMap.get("author").toString(),
                Integer.parseInt(bookMap.get("pages").toString()));
        book.setId(bookId);

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Book Updated successfully");
        response.put("book", bookRepository.save(book));
        return response;
    }

    // DELETE existing movie
    @RequestMapping(method = RequestMethod.DELETE, value="/{bookId}")
    public Map<String, String> deleteBook(@PathVariable("bookId") String bookId){
        bookRepository.delete(bookId);
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "Book deleted successfully");

        return response;
    }

    // GET ALL MOVIES TO DISPLAY
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("totalBooks", books.size());
        response.put("books", books);
        return response;
    }
}
