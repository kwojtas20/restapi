package pl.nullpointerexeption.restapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.nullpointerexeption.restapi.repository.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    Optional<Post> findById(long id); // Ta metoda jest generowana automatycznie przez springa

    List<Post> findAll();

    @Query("Select p From Post p")
    List<Post> findAllPosts(Pageable page);

    List<Post> findAllByTitle(String title, Pageable page);

    List<Post> findAllByContent(String content);

    List<Post> findByCreatedBetween(LocalDateTime from, LocalDateTime to);
}
