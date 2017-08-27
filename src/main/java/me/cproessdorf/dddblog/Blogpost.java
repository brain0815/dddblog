package me.cproessdorf.dddblog;

import java.util.Date;
import java.util.List;

public class Blogpost implements IBlogpost {

    private Long id;
    private String title;
    private String author;
    private String content;
    private Date creationDate;
    private List tags;

    public Blogpost(Long id, String title, String author, String content, Date creationDate, List tags) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
        this.tags = tags;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Date getCreationDate() { return creationDate; }

    @Override
    public List getTags() { return tags; }

    @Override
    public void setId(Long id) { this.id = id; }

    @Override
    public void setTitle(String title) { this.title = title; }

    @Override
    public void setAuthor(String author) { this.author = author; }

    @Override
    public void setContent(String content) { this.content = content; }

    @Override
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    @Override
    public void setTags(List tags) { this.tags = tags; }

}
