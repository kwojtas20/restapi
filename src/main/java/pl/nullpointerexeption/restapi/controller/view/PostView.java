package pl.nullpointerexeption.restapi.controller.view;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Ta klasa jest wykorzystywana przy pobieraniu danych w restach GET
 */
@Builder
public class PostView {

    private final long id;
    private final String title;
    private final String content;
    private final List<CommentView> comment;
    private final LocalDateTime created;
    private final LocalDateTime modified;
}
