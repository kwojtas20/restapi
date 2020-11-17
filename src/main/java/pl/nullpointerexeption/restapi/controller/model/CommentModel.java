package pl.nullpointerexeption.restapi.controller.model;

import lombok.Data;

/**
 * Ta klasa jest wykorzystywana przy ładowaniu danych w restach POST, PUT, PATCH
 */
@Data
public class CommentModel {

    private String content;
    private Long postId;
}
