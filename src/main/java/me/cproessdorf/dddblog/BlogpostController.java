package me.cproessdorf.dddblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class BlogpostController {

    @Autowired
    IBlogpostProvider blogpostProvider;

    @RequestMapping("/v1/posts")
    public List blogposts(@RequestParam(value="id", defaultValue="0") String id) {
        return blogpostProvider.giveMeAllBlogposts();
    }
}