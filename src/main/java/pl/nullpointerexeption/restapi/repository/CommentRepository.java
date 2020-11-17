package pl.nullpointerexeption.restapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.nullpointerexeption.restapi.repository.entity.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostIdIn(List<Long> ids);

    List<Comment> findAllByPostId(Long id);

    @Query("Select p From Comment p")
    List<Comment> findAllComments(Pageable page);
}
