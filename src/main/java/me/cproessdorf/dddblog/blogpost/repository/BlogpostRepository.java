package me.cproessdorf.dddblog.blogpost.repository;

import me.cproessdorf.dddblog.blogpost.Blogpost;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BlogpostRepository implements IBlogpostRepository {

    public BlogpostRepository() {

    }

    public Blogpost loadBlogpost(Long id) {
        System.out.println("==== Loading blogpost from repository ====");
        String now =  new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        List<String> tags = new ArrayList<String>();
        tags.add("BMW");
        tags.add("FORD");
        return new Blogpost(id, "Testtitle", "Testauthor", "Testcontent", now, tags);
    }

    public void addBlogpost(Blogpost blogpost) {
        System.out.println("==== Add blogpost to repository ====");
    }

    public void updateBlogpost(Blogpost blogpost) {
        System.out.println("==== Update blogpost to repository ====");
    }

    public void deleteBlogpost(Long id) {
        System.out.println("==== Deleting blogpost from repository ====");
    }
}
