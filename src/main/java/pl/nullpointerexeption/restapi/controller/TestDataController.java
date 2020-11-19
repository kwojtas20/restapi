package pl.nullpointerexeption.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexeption.restapi.service.TestDataService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestDataController {

    private final TestDataService testDataService;

    @PostMapping("/reload-all-test-data")
    public void reloadAllTestData() {
        testDataService.reloadAllTestData();
    }

    @PostMapping("/upload-all-test-data")
    public void uploadAllTestData() {
        testDataService.uploadAllTestData();
    }

    @DeleteMapping("/clear-all-test-data")
    public void clearTestAllData() {
        testDataService.clearAllTestData();
    }

    @PostMapping("/upload-test-users")
    public void uploadTestUsers() {
        testDataService.uploadTestUsers();
    }

    @PostMapping("/upload-test-posts")
    public void uploadTestPosts() {
        testDataService.uploadTestPosts();
    }

    @PostMapping("/upload-test-comments")
    public void uploadTestComments() {
        testDataService.uploadTestComments();
    }
}
