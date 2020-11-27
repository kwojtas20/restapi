package pl.nullpointerexeption.restapi.controller.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.nullpointerexeption.restapi.controller.model.PostModel;
import pl.nullpointerexeption.restapi.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class PostValidator {

    private final UserRepository userRepository;

    public void checkPostModel(PostModel postModel) {
        checkUserId(postModel);
        checkContent(postModel);
        checkTitle(postModel);
    }

    public void checkUserId(PostModel postModel) {
        if (postModel.getUserId() == null) {
            throw new RuntimeException("Brak id usersa");
        }
        userRepository.findById(postModel.getUserId()).orElseThrow(() -> new RuntimeException("User o podanym id nie istnieje"));
    }

    public void checkContent(PostModel postModel) {
        if (postModel.getContent() == null) {
            throw new RuntimeException("Brak komentarza");
        }
        if (postModel.getContent().length() > 2000) {
            throw new RuntimeException("Za długi komentarz");
        }
    }

    public void checkTitle(PostModel postModel) {
        if (postModel.getTitle() == null) {
            throw new RuntimeException("Brak tytułu");
        }
        if (postModel.getTitle().length() > 400) {
            throw new RuntimeException("Za długi tutuł");
        }
    }
}
