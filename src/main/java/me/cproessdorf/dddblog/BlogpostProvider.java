package me.cproessdorf.dddblog;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogpostProvider {


    public BlogpostProvider () {

    }

    public Blogpost giveMeABlogpostById(Long id){
        Date now = new Date();
        List<String> tags = new ArrayList<String>();
        Blogpost blogpost = new Blogpost(id, "foo", "bar", "lala", now, tags);
        return blogpost;
    }

    public List giveMeAllBlogposts() {
        List blogposts = new ArrayList();
        Date now = new Date();
        List<String> tags = new ArrayList<String>();
        Blogpost blogpost = new Blogpost((long) 1, "foo", "bar", "lala", now, tags);
        blogposts.add(blogpost);
        return blogposts;
    }
    public Boolean saveMyBlogpost(Blogpost blogpost) {
        return true;
    }
    Boolean updateMyBlogpost(Blogpost blogpost) {
        return true;
    }
    Boolean deleteABlogpostById(Long id) {
        return true;
    }
}
