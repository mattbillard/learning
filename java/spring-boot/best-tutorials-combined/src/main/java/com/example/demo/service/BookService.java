package com.example.demo.service;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.BookEs;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookDbRepository;
import com.example.demo.repository.BookEsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private Faker faker = new Faker(new Locale("en-IND"));

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookDbRepository bookRepository;


    String INDEX = "book_index";
    String TYPE = "book_type";
    @Autowired
    BookEsRepository esRepository;
    @Autowired
    private RestHighLevelClient esClient;
    @Autowired
    private ObjectMapper objectMapper;



    @CacheEvict(value={"todos", "book"}, allEntries=true)
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Cacheable("todo")
    public Optional<Book> read(Long id) {
        simulateSlowService();

        return bookRepository.findById(id);
    }

    @CacheEvict(value={"todos", "book"}, allEntries=true)
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @CacheEvict(value={"todos", "todo"}, allEntries=true)
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }


    // ----------


    @Cacheable("todos")
    public Iterable list(Pageable pageable) {
        simulateSlowService();

        return bookRepository.findAll(pageable);
    }


    @Cacheable("todos")
    public Iterable search(String searchFor) {
        return esRepository.search(new QueryStringQueryBuilder(searchFor));
    }


    // ----------


    @CacheEvict(value={"todos", "todo"}, allEntries=true)
    public void generate(int count) throws Exception {
        final int TOTAL_AUTHORS = 10;
        final int MAX_AUTHORS_PER_BOOK = 3;

        // Authors
        List<Author> authorList = new ArrayList<>();
        for (int i = 0; i < TOTAL_AUTHORS; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Author author = Author.builder().firstName(firstName).lastName(lastName).build();
            authorList.add(author);
        }
        authorRepository.saveAll(authorList);

        // Books
        Random random = new Random();
        List<Book> dbList = new ArrayList<>();
        List<BookEs> esList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Author> bookAuthors = new ArrayList<>();
            int numAuthors = random.nextInt(MAX_AUTHORS_PER_BOOK) + 1;
            for (int j = 0; j < numAuthors; j++) {
                int authorIdx = random.nextInt(TOTAL_AUTHORS);
                bookAuthors.add(authorList.get(authorIdx));
            }

            // Books in datbase
            UUID uuid = UUID.randomUUID();
            String genre = faker.book().genre();
            String publisher = faker.book().publisher();
            String title = faker.book().title();
            String text = faker.lorem().sentence();
            Book book = Book.builder().esId(uuid).author(bookAuthors).genre(genre).publisher(publisher).title(title).text(text).build();
            dbList.add(book);

            // Books in Elasticsearch
            BookEs bookEs = BookEs.builder().id(uuid).text(text).build();
            esList.add(bookEs);
        }

        // Database
        bookRepository.saveAll(dbList);

        // Elasticsearch
        BulkRequest req = new BulkRequest();
        esList.forEach(book -> req.add(new IndexRequest(INDEX, TYPE, book.getId().toString()).source(objectMapper.convertValue(book, Map.class))));
        esClient.bulk(req, RequestOptions.DEFAULT);
    }

    @CacheEvict(value={"todos", "todo"}, allEntries=true)
    public void deleteAll() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        esRepository.deleteAll();
    }


    // ----------


    private void simulateSlowService() {
        try {
            long time = 1500L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}
