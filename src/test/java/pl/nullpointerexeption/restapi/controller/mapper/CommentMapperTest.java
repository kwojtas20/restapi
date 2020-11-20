package pl.nullpointerexeption.restapi.controller.mapper;

import org.junit.jupiter.api.Test;
import pl.nullpointerexeption.restapi.controller.model.CommentModel;
import pl.nullpointerexeption.restapi.controller.view.CommentView;
import pl.nullpointerexeption.restapi.repository.entity.Comment;
import pl.nullpointerexeption.restapi.repository.entity.Post;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommentMapperTest {

    /**
     * 1. Tworzymymy nową listę z 2 komentarzami
     * 2. Mapujemy je na widoki
     * 3. Sprawdzamy zgodność pól
     */
    @Test
    void shouldMapToCommentViews() {
        //given
        Comment comment1 = new Comment();//Tworzy nowy obiekt typu Comment o nazwie comment1 przez konstruktor new Comment()
        comment1.setContent("komentarz1");//Przypisuje wartość "komentarz1" typu String do pola content w obiekcie comment1
        comment1.setId(1L);//Przypisuje wartość "1" typu Long do pola id w obiekcie comment1
        comment1.setPost(new Post());//Przypisuje nowy obiekt typu Post do pola post w obiekcie comment1
        comment1.setCreated(LocalDateTime.of(2020, Month.APRIL, 1, 12, 33));
        comment1.setModified(LocalDateTime.of(2019, Month.APRIL, 1, 12, 33));

        Comment comment2 = new Comment();//Tworzy nowy obiekt typu Comment o nazwie comment2 przez konstruktor new Comment()
        comment2.setContent("komentarz2");//Przypisuje wartość "komentarz2" typu String do pola content w obiekcie comment2
        comment2.setId(2L);//Przypisuje wartość "2" typu Long do pola id w obiekcie comment2
        comment2.setPost(new Post());//Przypisuje nowy obiekt typu Post do pola post w obiekcie comment2
        comment2.setCreated(LocalDateTime.of(2020, Month.AUGUST, 1, 12, 33));
        comment2.setModified(LocalDateTime.of(2019, Month.AUGUST, 1, 12, 33));
        List<Comment> comments = new ArrayList<>(); // Tworzy nową listę obiektów typu Comment o nazwie comments przez konstruktor new ArrayList<>()
        comments.add(comment1);//Do listy comments dodaje obiekt comment1
        comments.add(comment2);//Do listy comments dodaje obiekt comment2
        //when
        List<CommentView> commentViews = CommentMapper.mapToCommentViews(comments); // Używa metody statycznej mapToCommentViews z klasy CommentMapper do zmapowania listy comments i przypisuje wynik do nowej listy commentViews
        //then
        assertThat(commentViews).isNotNull(); // sprawdza czy zmapowana lista commentViews nie jest nullem
        assertThat(commentViews.size()).isEqualTo(comments.size()); // sprawdz czy rozmiar tablicy commentViews jest równy rozmiarowi tablicy comments
    }

    @Test
    void shouldMapToCommentView() {
        //given
        Comment comment1 = new Comment();//Tworzy nowy obiekt typu Comment o nazwie comment1 przez konstruktor new Comment()
        comment1.setContent("komentarz1");//Przypisuje wartość "komentarz1" typu String do pola content w obiekcie comment1
        comment1.setId(1L);//Przypisuje wartość "1" typu Long do pola id w obiekcie comment1
        comment1.setPost(new Post());//Przypisuje nowy obiekt typu Post do pola post w obiekcie comment1
        comment1.setCreated(LocalDateTime.of(2020, Month.APRIL, 1, 12, 33));
        comment1.setModified(LocalDateTime.of(2019, Month.APRIL, 1, 12, 33));
        //when
        CommentView commentView = CommentMapper.mapToCommentView(comment1);
        //then
        assertThat(commentView).isNotNull();
        assertThat(commentView.getId()).isEqualTo(comment1.getId());
        assertThat(commentView.getContent()).isEqualTo(comment1.getContent());
        assertThat(commentView.getCreated()).isEqualTo(comment1.getCreated());
        assertThat(commentView.getModified()).isEqualTo(comment1.getModified());
    }

    @Test
    void shouldReturnNullWhenCommentIsNull() {
        //when
        CommentView commentView = CommentMapper.mapToCommentView(null);
        //expect
        assertNull(commentView);
    }

    @Test
    void shouldReturnEmptyListNullWhenCommentListIsNull() {
        //when
        List<CommentView> commentViews = CommentMapper.mapToCommentViews(null);
        //expect
        assertTrue(commentViews.isEmpty());
    }

    @Test
    void shouldMapToComments() {
        List<CommentModel> commentModels = new ArrayList<>();
        commentModels.add(new CommentModel("KKKKKK", 1L));
        commentModels.add(new CommentModel("MMMMMM", 2L));
        //when
        List<Comment> comments = CommentMapper.mapToComments(commentModels);
        //then
        assertThat(comments).isNotNull();
        assertThat(comments.size()).isEqualTo(commentModels.size());
    }

    @Test
    void shouldMapToComment() {
        //given
        CommentModel commentModel = new CommentModel("KKKKKK", 1L);
        Comment.builder().content("commentModel");
        Comment.builder().build();
        //when
        Comment comment = CommentMapper.mapToComment(commentModel);
        //then
        assertThat(comment).isNotNull();
        assertThat(comment.getContent()).isEqualTo(commentModel.getContent());
    }

    @Test
    void shouldReturnNullWhenCommentModelIsNull() {
        //when
        Comment comment = CommentMapper.mapToComment(null);
        //expect
        assertNull(comment);
    }

    @Test
    void shouldReturnEmptyListWhenCommentModelListIsNull() {
        //when
        List<Comment> comments = CommentMapper.mapToComments(null);
        //expect
        assertTrue(comments.isEmpty());
    }
}
