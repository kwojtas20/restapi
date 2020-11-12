package pl.nullpointerexeption.restapi.controller.view;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Ta klasa jest wykorzystywana przy pobieraniu danych w restach GET
 */
@Value
public class PostView {

    long id;
    String title;
    String content;
    List<CommentView> comment;
    LocalDateTime created;
    LocalDateTime modified;
}
