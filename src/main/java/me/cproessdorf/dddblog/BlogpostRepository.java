package me.cproessdorf.dddblog;

public class BlogpostRepository implements IBlogpostRepository{

    public BlogpostRepository() {

    }

    public boolean persist(Blogpost blogpost) {
        return true;
    }

    public boolean delete(Blogpost blogpost) {
        return true;
    }
}
