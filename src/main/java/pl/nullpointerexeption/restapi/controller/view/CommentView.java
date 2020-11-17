package pl.nullpointerexeption.restapi.controller.view;

import lombok.Value;

import java.time.LocalDateTime;

/**
 * Ta klasa jest wykorzystywana przy pobieraniu danych w restach GET
 */
@Value
public class CommentView {

    Long id;
    LocalDateTime created;
    LocalDateTime modified;
    String content;
    Long postId;
}
