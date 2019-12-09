package com.example.demo.repository;

import com.example.demo.domain.BookEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEsRepository extends ElasticsearchRepository<BookEs, String> {

    // Example of more advanced query
    // List findBookByTitle(String title);


    // Examples of even more advanced queries

    // Page<Article> findByAuthorsName(String name, Pageable pageable);

    // @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    // Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);

    // @Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"tags\": \"?0\" }}}}")
    // Page<Article> findByFilteredTagQuery(String tag, Pageable pageable);

    // @Query("{\"bool\": {\"must\": {\"match\": {\"authors.name\": \"?0\"}}, \"filter\": {\"term\": {\"tags\": \"?1\" }}}}")
    // Page<Article> findByAuthorsNameAndFilteredTagQuery(String name, String tag, Pageable pageable);
}


// NOTES for self - below is the more manual way to make Elasticsearch calls

//@Repository
//public class BookEsRepository {
//    String INDEX = "book_index";
//    String TYPE = "book_type";
//
//    @Autowired
//    private RestHighLevelClient client;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    public Book create(Book document) throws Exception {
//        document.setId(UUID.randomUUID());
//        IndexRequest req = new IndexRequest(INDEX, TYPE, document.getId().toString()).source(objectMapper.convertValue(document, Map.class));
//        IndexResponse res = client.index(req, RequestOptions.DEFAULT);
//        return document; // Would be nice if ES gave us back the document
//    }
//
//    public Book read(String id) throws Exception {
//        GetRequest req = new GetRequest(INDEX, TYPE, id);
//        GetResponse res = client.get(req, RequestOptions.DEFAULT);
//        return objectMapper.convertValue(res.getSource(), Book.class);
//    }
//
//    public Book update(Book document) throws Exception {
//        UpdateRequest req = new UpdateRequest(INDEX, TYPE, document.getId().toString()).doc(objectMapper.convertValue(document, Map.class));
//        UpdateResponse res = client.update(req, RequestOptions.DEFAULT);
//        return document; // Would be nice if ES gave us back the document
//    }
//
//    public String deleteBookDocument(String id) throws Exception {
//        DeleteRequest req = new DeleteRequest(INDEX, TYPE, id);
//        DeleteResponse res = client.delete(req, RequestOptions.DEFAULT);
//        return id;
//    }
//
//
//    // ----------
//
//    public List<Book> list() throws Exception {
//        SearchRequest req = new SearchRequest().indices(INDEX).types(TYPE);
//        SearchResponse res = client.search(req, RequestOptions.DEFAULT);
//        return getSearchResult(res);
//    }
//
//    public List<Book> search(String searchFor) throws Exception {
//        // MatchQueryBuilder qb = QueryBuilders.matchQuery("title", searchFor);  // Search just one field
//        QueryStringQueryBuilder qb = QueryBuilders.queryStringQuery(searchFor); // Search all fields
//        SearchRequest req = new SearchRequest().indices(INDEX).types(TYPE).source(new SearchSourceBuilder().query(qb));
//        SearchResponse res = client.search(req, RequestOptions.DEFAULT);
//        return getSearchResult(res);
//    }
//
//
//    // ----------
//
//
//    private List<Book> getSearchResult(SearchResponse res) {
//        List<Book> books = Arrays.stream(res.getHits().getHits())
//            .map(hit -> objectMapper.convertValue(hit.getSourceAsMap(), Book.class))
//            .collect(Collectors.toList());
//        return books;
//    }
//}
