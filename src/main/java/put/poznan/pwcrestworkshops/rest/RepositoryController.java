package put.poznan.pwcrestworkshops.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import put.poznan.pwcrestworkshops.dto.GitHubRepository;
import put.poznan.pwcrestworkshops.exceptions.RepoException;
import put.poznan.pwcrestworkshops.service.MyService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class RepositoryController {

    private final MyService myService;

    public RepositoryController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping("/repos")
    public List<GitHubRepository> allRepos() {
        return List.of(
                new GitHubRepository(
                        "FirstRepo",
                        1L
                ),
                new GitHubRepository(
                        "SecondRepo",
                        2L
                )
        );
    }

    @GetMapping("/repos/{id}")
    public GitHubRepository getRepoById(
            @PathVariable Long id
    ) {
        log.info("get with id: [{}]", id);
        if (id == 1) {
            return new GitHubRepository(
                    "FirstRepo",
                    1L
            );
        }
        throw new RepoException("Not found");
    }
}
