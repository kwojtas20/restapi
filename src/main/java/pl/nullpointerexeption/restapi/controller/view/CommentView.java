package pl.nullpointerexeption.restapi.controller.view;

import lombok.Builder;

import java.time.LocalDateTime;

/**
 * Ta klasa jest wykorzystywana przy pobieraniu danych w restach GET
 */
@Builder
public class CommentView {

    private final long id;
    private final Long postId;
    private final String content;
    private final LocalDateTime created;
    private final LocalDateTime modified;
}
