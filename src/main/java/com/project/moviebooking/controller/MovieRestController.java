package com.project.moviebooking.controller;

import com.project.moviebooking.model.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
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
//        return bookRepository.findOne(bookId).map(m -> ResponseEntity.ok().body(m)).orElse(ResponseEntity.notFound().build());
        return null;

    }






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
                                        @Valid @RequestBody Map<String, Object> bookMap){
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
    @GetMapping
    public Map<String, Object> getAllBooks(){

        // sort :
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");

        List<Book> books = bookRepository.findAll(sortByCreatedAtDesc);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("totalBooks", books.size());
        response.put("books", books);
        return response;
    }
}


//
//@PutMapping(value="/todos/{id}")
//public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id,
//@Valid @RequestBody Todo todo) {
//        return todoRepository.findById(id)
//        .map(todoData -> {
//        todoData.setTitle(todo.getTitle());
//        todoData.setCompleted(todo.getCompleted());
//        Todo updatedTodo = todoRepository.save(todoData);
//        return ResponseEntity.ok().body(updatedTodo);
//        }).orElse(ResponseEntity.notFound().build());
//        }
//
//@DeleteMapping(value="/todos/{id}")
//public ResponseEntity<?> deleteTodo(@PathVariable("id") String id) {
//        return todoRepository.findById(id)
//        .map(todo -> {
//        todoRepository.deleteById(id);
//        return ResponseEntity.ok().build();
//        }).orElse(ResponseEntity.notFound().build());
//        }