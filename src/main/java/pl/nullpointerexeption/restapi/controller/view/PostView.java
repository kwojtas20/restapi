package pl.nullpointerexeption.restapi.controller.view;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Ta klasa jest wykorzystywana przy pobieraniu danych w restach GET
 */
@Value
public class PostView {

    Long id;
    LocalDateTime created;
    LocalDateTime modified;
    String title;
    String content;
    Long userId;
    List<CommentView> comments;
}
