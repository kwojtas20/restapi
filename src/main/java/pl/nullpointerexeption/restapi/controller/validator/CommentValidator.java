package pl.nullpointerexeption.restapi.controller.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.nullpointerexeption.restapi.controller.model.CommentModel;
import pl.nullpointerexeption.restapi.repository.PostRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommentValidator {

    private final PostRepository postRepository;

    public void checkCommentModel(CommentModel commentModel) {
        checkPostId(commentModel);
        checkContent(commentModel);
    }

    private void checkContent(CommentModel commentModel) {
        if (commentModel.getContent() == null) {
            throw new RuntimeException("Brak komentarza");
        }
        if (commentModel.getContent().length() > 2000) {
            throw new RuntimeException("Tekst komentarza jest za długi");
        }
    }

    private void checkPostId(CommentModel commentModel) {
        if (commentModel.getPostId() == null) {
            throw new RuntimeException("Brak postId");
        }
        postRepository.findById(commentModel.getPostId()).orElseThrow(() -> new RuntimeException("Post o podanym id nie istnieje"));
    }
}
