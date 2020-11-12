package pl.nullpointerexeption.restapi.controller.dto;

import lombok.Data;

/**
 * Ta klasa jest wykorzystywana przy ładowaniu danych w restach POST, PUT, PATCH
 */
@Data
public class PostDto {

    private final String title;
    private final String content;
}
