package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Book book) {
        Book created = service.create(book);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        Optional<Book> optional = service.read(id);
        Book book = optional.get();
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Book book) {
        Book updated = service.update(book);
        return new ResponseEntity(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    // ----------

    @GetMapping
    public ResponseEntity list(Pageable pageable) {
        Iterable<Book> todos = service.list(pageable); // http://localhost:8080/api/v1/todos?size=10&page=0&sort=description,asc
        return new ResponseEntity(todos, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam("search") String searchFor) {
        return new ResponseEntity(service.search(searchFor), HttpStatus.OK);
    }

    // ----------

    @GetMapping("/generate/{count}")
    public ResponseEntity generate(@PathVariable(value = "count") int count) throws Exception {
        service.generate(count);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/delete-all")
    public ResponseEntity deleteAll() throws Exception {
        service.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }
}
