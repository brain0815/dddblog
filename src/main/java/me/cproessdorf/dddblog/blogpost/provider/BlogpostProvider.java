package me.cproessdorf.dddblog.blogpost.provider;

import me.cproessdorf.dddblog.blogpost.Blogpost;
import me.cproessdorf.dddblog.blogpost.repository.BlogpostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BlogpostProvider {

    @Autowired
    BlogpostRepository blogpostRepository;

    public BlogpostProvider () {

    }

    public Blogpost giveMeABlogpostById(Long id){
        return blogpostRepository.loadBlogpost(id);
    }

    public List<Blogpost> giveMeAllBlogposts() {
        // hack for getting at least one post in the list
        Long id = Long.valueOf(1);
        List blogposts = new ArrayList();
        Blogpost blogpost = blogpostRepository.loadBlogpost(id);
        blogposts.add(blogpost);
        return blogposts;
    }
    public void saveMyBlogpost(Blogpost blogpost) {
        // add or update logic here
        blogpostRepository.addBlogpost(blogpost);
    }

    public void deleteABlogpostById(Long id) {
        blogpostRepository.deleteBlogpost(id);
    }
}
