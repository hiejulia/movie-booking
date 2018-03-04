package com.project.moviebooking.controller;

import com.project.moviebooking.model.Movie;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/movies")
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
    	<artifactId>springboot-rest-demo</artifactId>
	<version>0.1</version>
    <name>Spring Boot REST API Demo</name>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.2.3.RELEASE</version>
	</parent>
</project>
    spring-boot-starter-web
    In order to build RESTful Service we would need make use of: spring web, JSON processing libraries, embedded tomcat or tomcat libraries, may be some library for validators like Hibernate validator. We might not remember all the dependencies required or might have to refer to some place to know which dependencies are required.

    To solve such issues Spring Boot provides a pom already configured with the dependencies required to build a web application and that pom is called: spring-boot-starter-web. Updating our pom.xml to add it as a dependency we get:

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>net.javabeat</groupId>
	<artifactId>springboot-rest-demo</artifactId>
	<version>0.1</version>
    <name>Spring Boot REST API Demo</name>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.2.3.RELEASE</version>
	</parent>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
	</dependencies>
</project>
    Similarly we have a pom: spring-boot-starter-data-mongodb which includes dependencies to mongo java driver, spring transaction, spring data for mongodb. So our final pom.xml looks like:

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>net.javabeat</groupId>
	<artifactId>springboot-rest-demo</artifactId>
	<version>0.1</version>
    <name>Spring Boot REST API Demo</name>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.2.3.RELEASE</version>
	</parent>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
	</dependencies>
</project>
    Spring Boot Application
    We need to create a main class which initializes the Spring Boot application and runs it. We also annotate the class with @SpringBootApplication. This annotation is tells the Spring application to enable autoconfiguration and component scan and also tells the Spring application that this particular class is also a configuration:

            package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class Application {

        public static void main(String[] args) throws Exception {
            SpringApplication.run(new Object[] { Application.class }, args);
        }
    }
    Implementing the RESTful APIs
    Let me create a model class to hold Book details retrieved from DB.

            package app.model;

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
}
