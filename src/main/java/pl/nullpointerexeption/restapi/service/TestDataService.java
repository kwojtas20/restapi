package pl.nullpointerexeption.restapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.nullpointerexeption.restapi.controller.model.CommentModel;
import pl.nullpointerexeption.restapi.controller.model.PostModel;
import pl.nullpointerexeption.restapi.controller.model.UserModel;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestDataService {

    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;

    @Transactional
    public void reloadAllTestData() {
        log.info("Reload all test data - start");
        clearAllTestData();
        uploadAllTestData();
        log.info("Reload all test data - stop");
    }

    @Transactional
    public void clearAllTestData() {
        log.info("Clear all test data - start");
        userService.deleteAllUsers();
        postService.deleteAllPosts();
        commentService.deleteAllComments();
        log.info("Clear all test data - stop");
    }

    @Transactional
    public void uploadAllTestData() {
        log.info("Upload all test data - start");
        userService.addUsers(prepareTestUsers());
        postService.addPosts(prepareTestPosts());
        commentService.addComments(prepareTestComments());
        log.info("Upload all test data - stop");
    }

    public void uploadTestUsers() {
        log.info("Upload test users - start");
        userService.addUsers(prepareTestUsers());
        log.info("Upload test users - stop");
    }

    public void uploadTestPosts() {
        log.info("Upload test posts - start");
        postService.addPosts(prepareTestPosts());
        log.info("Upload test posts - stop");
    }

    public void uploadTestComments() {
        log.info("Upload test comments - start");
        commentService.addComments(prepareTestComments());
        log.info("Upload test comments - stop");
    }

    private List<UserModel> prepareTestUsers() {
        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel("Firstname 1", "Secondname 1", "Surname 1"));
        userModels.add(new UserModel("Firstname 2", "Secondname 2", "Surname 2"));
        userModels.add(new UserModel("Firstname 3", "Secondname 3", "Surname 3"));
        userModels.add(new UserModel("Firstname 4", "Secondname 4", "Surname 4"));
        userModels.add(new UserModel("Firstname 5", "Secondname 5", "Surname 5"));
        userModels.add(new UserModel("Firstname 6", "Secondname 6", "Surname 6"));
        userModels.add(new UserModel("Firstname 7", "Secondname 7", "Surname 7"));
        userModels.add(new UserModel("Firstname 8", "Secondname 8", "Surname 8"));
        userModels.add(new UserModel("Firstname 9", "Secondname 9", "Surname 9"));
        userModels.add(new UserModel("Firstname 10", "Secondname 10", "Surname 10"));
        return userModels;
    }

    private List<PostModel> prepareTestPosts() {
        List<PostModel> postModels = new ArrayList<>();
        userService.getAllUsers().forEach(userView -> {
            postModels.add(new PostModel("Title" + userView.getId(), "Content" + userView.getId(), userView.getId()));
            postModels.add(new PostModel("Title" + userView.getId(), "Content" + userView.getId(), userView.getId()));
        });
        return postModels;
    }

    private List<CommentModel> prepareTestComments() {
        List<CommentModel> commentModels = new ArrayList<>();
        postService.getAllPosts().forEach(postView -> {
            commentModels.add(new CommentModel("Content" + postView.getId(), postView.getId()));
            commentModels.add(new CommentModel("Content" + postView.getId(), postView.getId()));
        });
        return commentModels;
    }
}
