package rifqimuhammadaziz.springsoftdelete.repository;

import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springsoftdelete.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
