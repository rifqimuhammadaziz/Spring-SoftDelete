package rifqimuhammadaziz.springsoftdelete.service;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springsoftdelete.entity.Book;
import rifqimuhammadaziz.springsoftdelete.repository.BookRepository;

import javax.persistence.EntityManager;

@Service
public class BookService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Iterable<Book> findAll(boolean isDeleted) {
        // return bookRepository.findAll();
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Book> books = bookRepository.findAll();
        session.disableFilter("deletedBookFilter");
        return books;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }


}
