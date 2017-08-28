package me.cproessdorf.dddblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BlogpostController {

    @Autowired
    BlogpostProvider blogpostProvider;

    @RequestMapping(value = "/blogpost", method = RequestMethod.GET)
    public ResponseEntity<List<Blogpost>> listBlogposts() {
        List<Blogpost> blogs = blogpostProvider.giveMeAllBlogposts();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blogpost>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blogpost>>(blogs, HttpStatus.OK);
    }

   @RequestMapping(value = "/blogpost/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blogpost> getBlogpost(@PathVariable("id") Long id) {
        Blogpost user = blogpostProvider.giveMeABlogpostById(id);
        if (user == null) {
            return new ResponseEntity<Blogpost>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blogpost>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/blogpost/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlogpost(@RequestBody Blogpost blogpost,    UriComponentsBuilder ucBuilder) {
        blogpostProvider.saveMyBlogpost(blogpost);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blogpost/{id}").buildAndExpand(blogpost.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/blogpost/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blogpost> updateBlogpost(@PathVariable("id") long id, @RequestBody Blogpost blogpost) {
        Blogpost actualBlogpost = blogpostProvider.giveMeABlogpostById(id);

        if (actualBlogpost==null) {
            return new ResponseEntity<Blogpost>(HttpStatus.NOT_FOUND);
        }

        actualBlogpost.setTitle(blogpost.getTitle());
        actualBlogpost.setAuthor(blogpost.getAuthor());
        actualBlogpost.setContent(blogpost.getContent());
        actualBlogpost.setTags(blogpost.getTags());

        blogpostProvider.updateMyBlogpost(actualBlogpost);
        return new ResponseEntity<Blogpost>(actualBlogpost, HttpStatus.OK);
    }

    @RequestMapping(value = "/blogpost/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blogpost> deleteMyBlogpost(@PathVariable("id") long id) {
        Blogpost blogpost = blogpostProvider.giveMeABlogpostById(id);
        if (blogpost == null) {
            return new ResponseEntity<Blogpost>(HttpStatus.NOT_FOUND);
        }

        blogpostProvider.deleteABlogpostById(id);
        return new ResponseEntity<Blogpost>(HttpStatus.NO_CONTENT);
    }

}