package me.cproessdorf.dddblog.blogpost.controller;

import me.cproessdorf.dddblog.blogpost.Blogpost;
import me.cproessdorf.dddblog.blogpost.provider.BlogpostProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
public class BlogpostController {

    @Autowired
    BlogpostProvider blogpostProvider;

    // get all
    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/blogpost/v1")
    @RequestMapping(value = "/blogpost/v1", method = RequestMethod.GET)
    public ResponseEntity<List<Blogpost>> listBlogposts() {
        List<Blogpost> blogs = blogpostProvider.giveMeAllBlogposts();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blogpost>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blogpost>>(blogs, HttpStatus.OK);
    }
    // get one
    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/blogpost/v1/{id}")
    @RequestMapping(value = "/blogpost/v1/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blogpost> getBlogpost(@PathVariable("id") Long id) {
        Blogpost user = blogpostProvider.giveMeABlogpostById(id);
        if (user == null) {
            return new ResponseEntity<Blogpost>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blogpost>(user, HttpStatus.OK);
    }
    // create
    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/blogpost/v1")
    @RequestMapping(value = "/blogpost/v1", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlogpost(@RequestBody Blogpost blogpost,    UriComponentsBuilder ucBuilder) {
        blogpostProvider.saveMyBlogpost(blogpost);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blogpost/{id}").buildAndExpand(blogpost.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    // update
    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/blogpost/v1/{id}")
    @RequestMapping(value = "/blogpost/v1/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blogpost> updateBlogpost(@PathVariable("id") long id, @RequestBody Blogpost blogpost) {
        Blogpost actualBlogpost = blogpostProvider.giveMeABlogpostById(id);

        if (actualBlogpost==null) {
            return new ResponseEntity<Blogpost>(HttpStatus.NOT_FOUND);
        }

        actualBlogpost.setTitle(blogpost.getTitle());
        actualBlogpost.setAuthor(blogpost.getAuthor());
        actualBlogpost.setContent(blogpost.getContent());
        actualBlogpost.setTags(blogpost.getTags());

        blogpostProvider.saveMyBlogpost(actualBlogpost);
        return new ResponseEntity<Blogpost>(actualBlogpost, HttpStatus.OK);
    }
    // delete
    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/blogpost/v1/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blogpost> deleteMyBlogpost(@PathVariable("id") long id) {
        Blogpost blogpost = blogpostProvider.giveMeABlogpostById(id);
        if (blogpost == null) {
            return new ResponseEntity<Blogpost>(HttpStatus.NOT_FOUND);
        }

        blogpostProvider.deleteABlogpostById(id);
        return new ResponseEntity<Blogpost>(HttpStatus.NO_CONTENT);
    }

}